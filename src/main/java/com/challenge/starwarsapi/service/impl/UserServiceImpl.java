package com.challenge.starwarsapi.service.impl;

import com.challenge.starwarsapi.constant.ApiConstant;
import com.challenge.starwarsapi.model.User;
import com.challenge.starwarsapi.model.dto.AddUserDTO;
import com.challenge.starwarsapi.model.dto.ApiResponseDTO;
import com.challenge.starwarsapi.model.dto.UserDTO;
import com.challenge.starwarsapi.model.dto.UserLoginDTO;
import com.challenge.starwarsapi.repository.UserRepository;
import com.challenge.starwarsapi.security.CustomerDetailsService;
import com.challenge.starwarsapi.security.jwt.JwtFilter;
import com.challenge.starwarsapi.security.jwt.JwtUtil;
import com.challenge.starwarsapi.service.UserService;
import com.challenge.starwarsapi.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final CustomerDetailsService customerDetailsService;

    private final JwtUtil jwtUtil;

    private final JwtFilter jwtFilter;

    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<ApiResponseDTO<AddUserDTO>> signUp(Map<String, String> requestMap) {
        log.info("Internal user sign up {}", requestMap);
        try {
            if (validateSignUpMap(requestMap)) {
                User user = userRepository.findByEmail(requestMap.get("email"));
                if (Objects.isNull(user)) {
                    // Encode password antes de guardar en DB
                    String encodedPassword = passwordEncoder.encode(requestMap.get("password"));
                    requestMap.put("password", encodedPassword);

                    userRepository.save(getUserFromMap(requestMap));
                    AddUserDTO resUser = new AddUserDTO(requestMap.get("name"), requestMap.get("email"));
                    return ApiUtils.getResponseEntity("User successfully registered", HttpStatus.CREATED, resUser);
                } else {
                    return ApiUtils.getResponseEntity("User with this mail already exists", HttpStatus.BAD_REQUEST, null);
                }
            } else {
                return ApiUtils.getResponseEntity(ApiConstant.INVALID_DATA, HttpStatus.BAD_REQUEST, null);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return ApiUtils.getResponseEntity(ApiConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR, null);
    }

    @Override
    public ResponseEntity<ApiResponseDTO<UserLoginDTO>> login(Map<String, String> requestMap) {
        log.info("Login User {}", requestMap);
        User user = userRepository.findByEmail(requestMap.get("email"));
        try {

            if (Objects.isNull(user)) {
                throw new BadCredentialsException("Incorrect email");
            }

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestMap.get("email"), requestMap.get("password"))
            );

            if (authentication.isAuthenticated()) {
                String token = jwtUtil.generateToken(
                        customerDetailsService.getUserDetail().getEmail(),
                        customerDetailsService.getUserDetail().getRole()
                );

                UserLoginDTO userLoginDTO = new UserLoginDTO(user.getId(), token, user.getName(), user.getEmail(), jwtUtil.extractExpiration(token));
                return ApiUtils.getResponseEntity("Login successful", HttpStatus.OK, userLoginDTO);

            }
        } catch (Exception exception) {
            log.error("", exception);
        }

        return ApiUtils.getResponseEntity("Incorrect Credentials", HttpStatus.BAD_REQUEST, null);
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return null;
    }

    private boolean validateSignUpMap(Map<String, String> requestMap) {
        return requestMap.containsKey("name") && requestMap.containsKey("email") && requestMap.containsKey("password");
    }

    private User getUserFromMap(Map<String, String> requestMap) {
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setRole("user");
        return user;
    }
}

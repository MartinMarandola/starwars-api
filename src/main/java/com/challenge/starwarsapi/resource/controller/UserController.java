package com.challenge.starwarsapi.resource.controller;

import com.challenge.starwarsapi.model.dto.user.AddUserDTO;
import com.challenge.starwarsapi.model.dto.ApiResponseDTO;
import com.challenge.starwarsapi.model.dto.user.UserDTO;
import com.challenge.starwarsapi.model.dto.user.UserLoginDTO;
import com.challenge.starwarsapi.resource.UserResource;
import com.challenge.starwarsapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController implements UserResource {


    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponseDTO<AddUserDTO>> userSignUp(@RequestBody(required = true) Map<String, String> requestMap) {
        log.info("requested: userSignUp({}) ", requestMap);
        return userService.signUp(requestMap);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponseDTO<UserLoginDTO>> login(@RequestBody(required = true) Map<String, String> requestMap) {
        log.info("requested: login({}) ", requestMap);
        return userService.login(requestMap);
    }

    @GetMapping("/get")
    public ResponseEntity<ApiResponseDTO<List<UserDTO>>> getAllUsers() {
        log.info("requested: getAllUsers()");
        return userService.getAllUsers();
    }
}

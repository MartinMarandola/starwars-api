package com.challenge.starwarsapi.service;

import com.challenge.starwarsapi.model.dto.AddUserDTO;
import com.challenge.starwarsapi.model.dto.ApiResponseDTO;
import com.challenge.starwarsapi.model.dto.UserDTO;
import com.challenge.starwarsapi.model.dto.UserLoginDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserService {

    ResponseEntity<ApiResponseDTO<AddUserDTO>> signUp(Map<String, String> requestMap);

    ResponseEntity<ApiResponseDTO<UserLoginDTO>> login(Map<String, String> requestMap);

    ResponseEntity<List<UserDTO>> getAllUsers();

}

package com.challenge.starwarsapi.service;

import com.challenge.starwarsapi.model.dto.ApiResponseDTO;
import com.challenge.starwarsapi.model.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserService {

    ResponseEntity<ApiResponseDTO<String>> signUp(Map<String,String> requestMap);

    ResponseEntity<ApiResponseDTO<String>> login(Map<String,String> requestMap);

    ResponseEntity<List<UserDTO>> getAllUsers();

}

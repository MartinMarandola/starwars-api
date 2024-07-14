package com.challenge.starwarsapi.controller;

import com.challenge.starwarsapi.constant.ApiConstant;
import com.challenge.starwarsapi.model.dto.AddUserDTO;
import com.challenge.starwarsapi.model.dto.ApiResponseDTO;
import com.challenge.starwarsapi.service.UserService;
import com.challenge.starwarsapi.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponseDTO<AddUserDTO>> userSignUp(@RequestBody(required = true) Map<String,String> requestMap){
        try{
            return userService.signUp(requestMap);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return ApiUtils.getResponseEntity(ApiConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR, null);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponseDTO<String>> login(@RequestBody(required = true) Map<String,String> requestMap){
        try{
            return userService.login(requestMap);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return ApiUtils.getResponseEntity(ApiConstant.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR, null);
    }
}

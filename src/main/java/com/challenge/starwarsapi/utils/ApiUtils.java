package com.challenge.starwarsapi.utils;

import com.challenge.starwarsapi.model.dto.ApiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiUtils {

    private ApiUtils(){}

    public static ResponseEntity<ApiResponseDTO<String>> getResponseEntity(String message, HttpStatus httpStatus) {
        ApiResponseDTO<String> responseDTO = new ApiResponseDTO<>(
                httpStatus.is2xxSuccessful(),
                message,
                null
        );
        return new ResponseEntity<>(responseDTO, httpStatus);
    }

}

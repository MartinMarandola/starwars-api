package com.challenge.starwarsapi.utils;

import com.challenge.starwarsapi.model.dto.ApiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiUtils {

    private ApiUtils(){}

    public static <T> ResponseEntity<ApiResponseDTO<T>> getResponseEntity(String message, HttpStatus httpStatus, T data) {
        ApiResponseDTO<T> responseDTO = new ApiResponseDTO<>(
                httpStatus.is2xxSuccessful(),
                message,
                data
        );
        return new ResponseEntity<>(responseDTO, httpStatus);
    }

}

package com.challenge.starwarsapi.handler;

import com.challenge.starwarsapi.model.dto.ApiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@ResponseBody
public class GlobalControllerAdvice {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponseDTO<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return new ApiResponseDTO<>(false, ex.getMessage(), null);
    }
}

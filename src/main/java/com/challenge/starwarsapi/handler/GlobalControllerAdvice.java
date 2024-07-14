package com.challenge.starwarsapi.handler;

import com.challenge.starwarsapi.handler.exception.FeignErrorListException;
import com.challenge.starwarsapi.model.dto.ApiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@ResponseBody
public class GlobalControllerAdvice {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiResponseDTO<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return new ApiResponseDTO<>(false, ex.getMessage(), null);
    }

    @ExceptionHandler(FeignErrorListException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponseDTO<Object> handleFeignException(FeignErrorListException ex) {
        return new ApiResponseDTO<>(false, ex.getMessage(), null);
    }
}

package com.challenge.starwarsapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "API response DTO")
public class ApiResponseDTO<T> {
    private Boolean success;
    private String message;
    private T data;
}

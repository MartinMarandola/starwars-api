package com.challenge.starwarsapi.model.dto.film;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
@Data
@Schema(description = "Film response DTO")
public class FilmResponseDTO {
    private String message;
    private List<FilmResultDTO> result;
}

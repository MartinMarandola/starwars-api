package com.challenge.starwarsapi.model.dto.film;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Get film by id DTO")
public class FilmByIdResponseDTO {
    private String message;
    private FilmResultDTO result;
}

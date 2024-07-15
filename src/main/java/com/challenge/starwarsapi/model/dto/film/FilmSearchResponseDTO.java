package com.challenge.starwarsapi.model.dto.film;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Get film by name DTO")
public class FilmSearchResponseDTO {
    private List<FilmResultDTO> result;
}

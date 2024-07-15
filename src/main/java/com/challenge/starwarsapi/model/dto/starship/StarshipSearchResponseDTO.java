package com.challenge.starwarsapi.model.dto.starship;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Get starship by name DTO")
public class StarshipSearchResponseDTO {
    private List<StarshipResultDTO> result;
}

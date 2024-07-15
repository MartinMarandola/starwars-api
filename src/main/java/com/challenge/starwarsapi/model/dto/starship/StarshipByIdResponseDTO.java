package com.challenge.starwarsapi.model.dto.starship;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Get starship by id DTO")
public class StarshipByIdResponseDTO {
    private StarshipResultDTO result;
}

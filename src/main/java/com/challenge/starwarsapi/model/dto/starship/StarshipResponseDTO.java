package com.challenge.starwarsapi.model.dto.starship;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Starship response DTO")
public class StarshipResponseDTO {
    private List<StarshipDTO> results;
    private int totalRecords;
}

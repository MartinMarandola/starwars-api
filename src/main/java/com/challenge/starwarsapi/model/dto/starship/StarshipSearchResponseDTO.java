package com.challenge.starwarsapi.model.dto.starship;

import lombok.Data;

import java.util.List;

@Data
public class StarshipSearchResponseDTO {
    private List<StarshipResultDTO> result;
}

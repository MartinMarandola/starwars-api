package com.challenge.starwarsapi.model.dto.starship;

import lombok.Data;

import java.util.List;

@Data
public class StarshipResponseDTO {
    private List<StarshipDTO> results;
    private int totalRecords;
}

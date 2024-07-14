package com.challenge.starwarsapi.model.dto.film;

import lombok.Data;

import java.util.List;
@Data
public class FilmResponseDTO {
    private List<FilmResultDTO> result;
    private int totalRecords;
}

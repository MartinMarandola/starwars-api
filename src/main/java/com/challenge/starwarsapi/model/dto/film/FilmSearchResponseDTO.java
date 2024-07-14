package com.challenge.starwarsapi.model.dto.film;


import lombok.Data;

import java.util.List;

@Data
public class FilmSearchResponseDTO {
    private List<FilmResultDTO> result;
}

package com.challenge.starwarsapi.service;

import com.challenge.starwarsapi.model.dto.film.FilmByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.film.FilmResultDTO;
import com.challenge.starwarsapi.model.dto.film.FilmSearchResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilmService {

    Page<FilmResultDTO> getFilm(Pageable pageable);

    FilmByIdResponseDTO getFilmById(String id);

    FilmSearchResponseDTO getFilmByTitle(String title);
}

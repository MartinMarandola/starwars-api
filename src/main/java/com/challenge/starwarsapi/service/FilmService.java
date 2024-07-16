package com.challenge.starwarsapi.service;

import com.challenge.starwarsapi.model.dto.film.FilmByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.film.FilmResponseDTO;
import com.challenge.starwarsapi.model.dto.film.FilmSearchResponseDTO;

public interface FilmService {

    FilmResponseDTO getFilm();

    FilmByIdResponseDTO getFilmById(String id);

    FilmSearchResponseDTO getFilmByTitle(String title);
}

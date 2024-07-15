package com.challenge.starwarsapi.service.impl;

import com.challenge.starwarsapi.client.FilmClient;
import com.challenge.starwarsapi.model.dto.film.FilmByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.film.FilmResponseDTO;
import com.challenge.starwarsapi.model.dto.film.FilmResultDTO;
import com.challenge.starwarsapi.model.dto.film.FilmSearchResponseDTO;
import com.challenge.starwarsapi.service.FilmService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmClient filmClient;

    @Override
    public FilmResponseDTO getFilm() {

       return filmClient.getFilms();


    }

    public FilmByIdResponseDTO getFilmById (String id){
        return filmClient.getFilmById(id);
    }

    @Override
    public FilmSearchResponseDTO getFilmByTitle(String title) {
        return filmClient.getFilmByTitle(title);
    }
}

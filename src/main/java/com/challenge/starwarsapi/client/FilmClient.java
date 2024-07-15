package com.challenge.starwarsapi.client;

import com.challenge.starwarsapi.model.dto.film.FilmByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.film.FilmResponseDTO;
import com.challenge.starwarsapi.model.dto.film.FilmSearchResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "filmClient", url = "https://www.swapi.tech/api", path = "/films")
public interface FilmClient {

    @GetMapping
    FilmResponseDTO getFilms();

    @GetMapping("/{id}")
    FilmByIdResponseDTO getFilmById(@PathVariable("id") String id);

    @GetMapping
    FilmSearchResponseDTO getFilmByTitle(@RequestParam("title") String title);
}

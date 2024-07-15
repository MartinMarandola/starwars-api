package com.challenge.starwarsapi.resource.controller;

import com.challenge.starwarsapi.model.dto.film.FilmByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.film.FilmResponseDTO;
import com.challenge.starwarsapi.model.dto.film.FilmResultDTO;
import com.challenge.starwarsapi.model.dto.film.FilmSearchResponseDTO;
import com.challenge.starwarsapi.resource.FilmResource;
import com.challenge.starwarsapi.service.FilmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/films")
@RequiredArgsConstructor
public class FilmController implements FilmResource {

    private final FilmService filmService;

    @GetMapping
    public ResponseEntity<FilmResponseDTO> getFilms(){
        log.info("Requested: getFilms()");
        return ResponseEntity.ok(filmService.getFilm());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmByIdResponseDTO> getFilmById(@PathVariable("id") String id){
        log.info("Requested: getFilmById(): ID {}", id);
        FilmByIdResponseDTO film = filmService.getFilmById(id);
        return ResponseEntity.ok(film);
    }

    @GetMapping("/search")
    public ResponseEntity<FilmSearchResponseDTO> getFilmByTitle(@RequestParam("title") String title){
        log.info("Requested: getFilmByTitle(): {}", title);
        FilmSearchResponseDTO film = filmService.getFilmByTitle(title);
        return ResponseEntity.ok(film);
    }
}

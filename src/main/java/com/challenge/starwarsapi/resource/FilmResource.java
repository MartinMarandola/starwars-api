package com.challenge.starwarsapi.resource;

import com.challenge.starwarsapi.model.dto.film.FilmByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.film.FilmResponseDTO;
import com.challenge.starwarsapi.model.dto.film.FilmResultDTO;
import com.challenge.starwarsapi.model.dto.film.FilmSearchResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Tag(name = "Film API Resources", description = "Film API Controller")
public interface FilmResource {

    @Operation(
            summary = "Get method to list SWAPI Films",
            description = "List all Star Wars films"

    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
    })
    ResponseEntity<FilmResponseDTO> getFilms();

    @Operation(
            summary = "Get Film method of SWAPI by id",
            description = "Obtain film by id"

    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
    })
    ResponseEntity<FilmByIdResponseDTO> getFilmById(@Parameter(description = "Film id number") String id);

    @Operation(
            summary = "Get Film method of SWAPI by name",
            description = "List films by their name"

    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
    })
    ResponseEntity<FilmSearchResponseDTO> getFilmByTitle(@Parameter(description = "Film title") String title);
}

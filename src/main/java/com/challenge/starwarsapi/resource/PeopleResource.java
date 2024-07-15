package com.challenge.starwarsapi.resource;

import com.challenge.starwarsapi.model.dto.people.PeopleByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.people.PeopleDTO;
import com.challenge.starwarsapi.model.dto.people.PeopleSearchResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Tag(name = "People API Resources", description = "People API Controller")
public interface PeopleResource {

    @Operation(
            summary = "Get method to list SWAPI People",
            description = "List all Star Wars people"

    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
    })
    ResponseEntity<Page<PeopleDTO>> getPeople(@Parameter(description = "Pageable object",
            example = "curl --location 'http://server:port/people?page=2&size=20' \\\n" +
                    "--header 'Authorization: ••••••' ") Pageable pageable);

    @Operation(
            summary = "Get People method of SWAPI by id",
            description = "Obtain people by id"

    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
    })
    ResponseEntity<PeopleByIdResponseDTO> getPeopleById(@Parameter(description = "Person id number") String id);

    @Operation(
            summary = "Get People method of SWAPI by name",
            description = "List people by their name"

    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
    })
    ResponseEntity<PeopleSearchResponseDTO> getPeopleByName(@Parameter(description = "Person name") String name);
}

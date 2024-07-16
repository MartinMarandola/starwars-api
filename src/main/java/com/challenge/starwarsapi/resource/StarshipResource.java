package com.challenge.starwarsapi.resource;

import com.challenge.starwarsapi.model.dto.starship.StarshipByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.starship.StarshipDTO;
import com.challenge.starwarsapi.model.dto.starship.StarshipSearchResponseDTO;
import com.challenge.starwarsapi.model.dto.vehicle.VehicleByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.vehicle.VehicleDTO;
import com.challenge.starwarsapi.model.dto.vehicle.VehicleSearchResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Tag(name = "Starship API Resources", description = "Starship API Controller")
public interface StarshipResource {
    @Operation(
            summary = "Get method to list SWAPI Starships",
            description = "List all Star Wars starships"

    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
    })
    ResponseEntity<Page<StarshipDTO>> getStarships(@Parameter(description = "Pageable object") Pageable pageable);

    @Operation(
            summary = "Get starship method of SWAPI by id",
            description = "Obtain starship by id"

    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
    })
    ResponseEntity<StarshipByIdResponseDTO> getStarshipById(@Parameter(description = "Starship id number") String id);

    @Operation(
            summary = "Get starship method of SWAPI by name",
            description = "List starships by their name"

    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
    })
    ResponseEntity<StarshipSearchResponseDTO> getStarshipByName(@Parameter(description = "Starship name") String name);
}

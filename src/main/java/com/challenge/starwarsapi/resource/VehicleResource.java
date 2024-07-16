package com.challenge.starwarsapi.resource;

import com.challenge.starwarsapi.model.dto.people.PeopleByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.people.PeopleDTO;
import com.challenge.starwarsapi.model.dto.people.PeopleSearchResponseDTO;
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

@Tag(name = "Vehicle API Resources", description = "Vehicle API Controller")
public interface VehicleResource {

    @Operation(
            summary = "Get method to list SWAPI Vehicles",
            description = "List all Star Wars vehicles"

    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
    })
    ResponseEntity<Page<VehicleDTO>> getVehicles(@Parameter(description = "Pageable object") Pageable pageable);

    @Operation(
            summary = "Get vehicle method of SWAPI by id",
            description = "Obtain vehicle by id"

    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
    })
    ResponseEntity<VehicleByIdResponseDTO> getVehicleById(@Parameter(description = "Vehicle id number") String id);

    @Operation(
            summary = "Get vehicle method of SWAPI by name",
            description = "List vehicles by their name"

    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
    })
    ResponseEntity<VehicleSearchResponseDTO> getVehicleByName(@Parameter(description = "Vehicle name") String name);
}

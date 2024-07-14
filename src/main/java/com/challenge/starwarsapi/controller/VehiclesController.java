package com.challenge.starwarsapi.controller;

import com.challenge.starwarsapi.model.dto.starship.StarshipByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.starship.StarshipDTO;
import com.challenge.starwarsapi.model.dto.starship.StarshipSearchResponseDTO;
import com.challenge.starwarsapi.model.dto.vehicle.VehicleByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.vehicle.VehicleDTO;
import com.challenge.starwarsapi.model.dto.vehicle.VehicleSearchResponseDTO;
import com.challenge.starwarsapi.service.StarshipService;
import com.challenge.starwarsapi.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/vehicles")
@RequiredArgsConstructor
public class VehiclesController {

    public final VehicleService vehicleService;


    @GetMapping
    public ResponseEntity<Page<VehicleDTO>> getVehicles(@PageableDefault(size = 10) Pageable pageable) {
        log.info("Requested: getVehicles()");
        return ResponseEntity.ok(vehicleService.getVehicles(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleByIdResponseDTO> getVehicleById(@PathVariable("id") String id) {
        log.info("Requested: getVehicleById(): ID {}", id);
        VehicleByIdResponseDTO vehicle = vehicleService.getVehicleById(id);
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping("/search")
    public ResponseEntity<VehicleSearchResponseDTO> getVehicleByName(@RequestParam("name") String name) {
        log.info("Requested: getStarshipByName(): {}", name);
        VehicleSearchResponseDTO vehicle = vehicleService.getVehicleByName(name);
        return ResponseEntity.ok(vehicle);
    }
}

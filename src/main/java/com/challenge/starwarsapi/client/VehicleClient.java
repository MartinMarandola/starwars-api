package com.challenge.starwarsapi.client;

import com.challenge.starwarsapi.model.dto.vehicle.VehicleByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.vehicle.VehicleResponseDTO;
import com.challenge.starwarsapi.model.dto.vehicle.VehicleSearchResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "vehicleClient", url = "https://www.swapi.tech/api", path = "/vehicles")
public interface VehicleClient {

    @GetMapping
    VehicleResponseDTO getVehicles(@RequestParam("page") int page, @RequestParam("size") int size);

    @GetMapping("/{id}")
    VehicleByIdResponseDTO getVehicleById(@PathVariable("id") String id);

    @GetMapping
    VehicleSearchResponseDTO getVehicleByName(@RequestParam("name") String name);
}

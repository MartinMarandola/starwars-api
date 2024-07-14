package com.challenge.starwarsapi.service;

import com.challenge.starwarsapi.model.dto.vehicle.VehicleByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.vehicle.VehicleDTO;
import com.challenge.starwarsapi.model.dto.vehicle.VehicleSearchResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VehicleService {
    Page<VehicleDTO> getVehicles(Pageable pageable);

    VehicleByIdResponseDTO getVehicleById(String id);

    VehicleSearchResponseDTO getVehicleByName(String name);
}

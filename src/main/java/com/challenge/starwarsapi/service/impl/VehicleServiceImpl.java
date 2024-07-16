package com.challenge.starwarsapi.service.impl;

import com.challenge.starwarsapi.client.VehicleClient;
import com.challenge.starwarsapi.model.dto.vehicle.VehicleByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.vehicle.VehicleDTO;
import com.challenge.starwarsapi.model.dto.vehicle.VehicleResponseDTO;
import com.challenge.starwarsapi.model.dto.vehicle.VehicleSearchResponseDTO;
import com.challenge.starwarsapi.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleClient vehicleClient;

    @Override
    public Page<VehicleDTO> getVehicles(Pageable pageable) {
        int page = pageable.getPageNumber();
        int size = pageable.getPageSize();

        VehicleResponseDTO response = vehicleClient.getVehicles(page, size);

        List<VehicleDTO> people = response.getResults();
        int totalRecords = response.getTotalRecords();

        return new PageImpl<>(people, pageable, totalRecords);
    }

    @Override
    public VehicleByIdResponseDTO getVehicleById(String id) {
        return vehicleClient.getVehicleById(id);
    }

    @Override
    public VehicleSearchResponseDTO getVehicleByName(String name) {
        return vehicleClient.getVehicleByName(name);
    }
}

package com.challenge.starwarsapi.model.dto.vehicle;

import lombok.Data;

import java.util.List;

@Data
public class VehicleResponseDTO {
    private List<VehicleDTO> results;
    private int totalRecords;
}

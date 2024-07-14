package com.challenge.starwarsapi.model.dto.vehicle;

import lombok.Data;

import java.util.List;

@Data
public class VehicleSearchResponseDTO {
    private List<VehicleResultDTO> result;
}

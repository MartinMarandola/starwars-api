package com.challenge.starwarsapi.model.dto.vehicle;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Vehicle Response DTO")
public class VehicleResponseDTO {
    private List<VehicleDTO> results;
    private int totalRecords;
}

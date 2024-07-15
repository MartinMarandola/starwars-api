package com.challenge.starwarsapi.model.dto.vehicle;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Get vehicle by name DTO")
public class VehicleSearchResponseDTO {
    private List<VehicleResultDTO> result;
}

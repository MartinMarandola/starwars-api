package com.challenge.starwarsapi.model.dto.vehicle;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Get vehicle by id DTO")
public class VehicleByIdResponseDTO {
    private VehicleResultDTO result;
}

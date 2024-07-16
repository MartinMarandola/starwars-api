package com.challenge.starwarsapi.model.dto.vehicle;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Vehicle result DTO")
public class VehicleResultDTO {
    private VehiclePropertiesDTO properties;
    private String description;
    private String _id;
    private String uid;
    private int __v;
}

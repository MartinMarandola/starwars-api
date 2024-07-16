package com.challenge.starwarsapi.model.dto.vehicle;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(description = "Vehicle DTO")
public class VehicleDTO {
    private String uid;
    private String name;
    private String url;

}

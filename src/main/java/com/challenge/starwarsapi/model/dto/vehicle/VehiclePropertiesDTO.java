package com.challenge.starwarsapi.model.dto.vehicle;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Vehicle properties DTO")
public class VehiclePropertiesDTO {
    private String model;
    private String starship_class;
    private String manufacturer;
    private String cost_in_credits;
    private String length;
    private String crew;
    private String passengers;
    private String max_atmosphering_speed;
    private String hyperdrive_rating;
    private String MGLT;
    private String cargo_capacity;
    private String consumables;
    private String[] pilots;
    private String created;
    private String edited;
    private String name;
    private String url;
}

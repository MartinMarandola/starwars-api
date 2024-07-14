package com.challenge.starwarsapi.model.dto.vehicle;

import lombok.Data;

@Data
public class VehicleResultDTO {
    private VehiclePropertiesDTO properties;
    private String description;
    private String _id;
    private String uid;
    private int __v;
}

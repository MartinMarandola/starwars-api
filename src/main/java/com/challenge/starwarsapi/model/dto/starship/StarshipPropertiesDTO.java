package com.challenge.starwarsapi.model.dto.starship;

import lombok.Data;

@Data
public class StarshipPropertiesDTO {
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

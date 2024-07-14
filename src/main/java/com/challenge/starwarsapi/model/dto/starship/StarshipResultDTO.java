package com.challenge.starwarsapi.model.dto.starship;

import lombok.Data;

@Data
public class StarshipResultDTO {
    private StarshipPropertiesDTO properties;
    private String description;
    private String _id;
    private String uid;
    private int __v;
}

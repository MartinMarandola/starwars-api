package com.challenge.starwarsapi.model.dto.starship;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Starship result DTO")
public class StarshipResultDTO {
    private StarshipPropertiesDTO properties;
    private String description;
    private String _id;
    private String uid;
    private int __v;
}

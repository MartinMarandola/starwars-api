package com.challenge.starwarsapi.model.dto.film;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Film result DTO")
public class FilmResultDTO {
    private FilmPropertiesDTO properties;
    private String description;
    private String _id;
    private String uid;
    private int __v;
}

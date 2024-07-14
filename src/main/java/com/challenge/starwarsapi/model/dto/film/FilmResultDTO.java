package com.challenge.starwarsapi.model.dto.film;

import lombok.Data;

@Data
public class FilmResultDTO {
    private FilmPropertiesDTO properties;
    private String description;
    private String _id;
    private String uid;
    private int __v;
}

package com.challenge.starwarsapi.model.dto.film;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Film properties")
public class FilmPropertiesDTO {
    private String[] characters;
    private String[] planets;
    private String[] starships;
    private String[] vehicles;
    private String[] species;
    private String created;
    private String edited;
    private String producer;
    private String title;
    private int episode_id;
    private String director;
    private String release_date;
    private String opening_crawl;
    private String url;
}

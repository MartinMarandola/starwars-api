package com.challenge.starwarsapi.model.dto.people;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "People properties DTO")
public class PeoplePropertiesDTO {
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String created;
    private String edited;
    private String name;
    private String homeworld;
    private String url;
}

package com.challenge.starwarsapi.model.dto;

import lombok.Data;

@Data
public class PeopleByIdResponseDTO {
    private String name;
    private String birth_year;
    private String eye_color;
    private String gender;
    private String hair_color;
    private String height;
    private String mass;
    private String skin_color;
    private String homeworld;
    private String [] films;
    private String [] species;
    private String [] starships;
    private String [] vehicles;
    private String url;
    private String created;
    private String edited;
}

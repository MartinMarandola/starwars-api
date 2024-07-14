package com.challenge.starwarsapi.model.dto.people;

import lombok.Data;

@Data
public class PeopleResultDTO {
    private PeoplePropertiesDTO properties;
    private String description;
    private String _id;
    private String uid;
    private int __v;
}

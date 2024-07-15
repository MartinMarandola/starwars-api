package com.challenge.starwarsapi.model.dto.people;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "People resulto DTO")
public class PeopleResultDTO {
    private PeoplePropertiesDTO properties;
    private String description;
    private String _id;
    private String uid;
    private int __v;
}

package com.challenge.starwarsapi.model.dto.people;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "People DTO")
public class PeopleDTO {
    private String uid;
    private String name;
    private String url;
}

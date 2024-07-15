package com.challenge.starwarsapi.model.dto.people;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "People DTO")
public class PeopleDTO {
    private String uid;
    private String name;
    private String url;
}

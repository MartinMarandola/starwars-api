package com.challenge.starwarsapi.model.dto.starship;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(description = "Starship DTO")
public class StarshipDTO {
    private String uid;
    private String name;
    private String url;

}

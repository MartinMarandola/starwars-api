package com.challenge.starwarsapi.model.dto.people;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Get people by id DTO")
public class PeopleByIdResponseDTO {
    private PeopleResultDTO result;
}

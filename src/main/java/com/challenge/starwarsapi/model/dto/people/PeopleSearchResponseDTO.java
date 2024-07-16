package com.challenge.starwarsapi.model.dto.people;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Get people by name DTO")
public class PeopleSearchResponseDTO {
    private String message;
    private List<PeopleResultDTO> result;
}

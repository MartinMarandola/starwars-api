package com.challenge.starwarsapi.model.dto.people;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "People response DTO")
public class PeopleResponseDTO {
    private List<PeopleDTO> results;
    private int totalRecords;
}

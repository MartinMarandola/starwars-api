package com.challenge.starwarsapi.model.dto.people;

import lombok.Data;

import java.util.List;

@Data
public class PeopleSearchResponseDTO {
    private List<PeopleResultDTO> result;
}

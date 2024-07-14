package com.challenge.starwarsapi.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class PeopleResponseDTO {
    private List<PeopleDTO> results;
    private int totalRecords;
}

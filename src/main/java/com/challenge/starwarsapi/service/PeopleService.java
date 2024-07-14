package com.challenge.starwarsapi.service;

import com.challenge.starwarsapi.model.dto.PeopleByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.PeopleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PeopleService {

    Page<PeopleDTO> getPeople(Pageable pageable);
    PeopleByIdResponseDTO getPeopleById(String id);
    PeopleByIdResponseDTO getPeopleByName(String name);
}

package com.challenge.starwarsapi.service;

import com.challenge.starwarsapi.model.dto.people.PeopleByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.people.PeopleDTO;
import com.challenge.starwarsapi.model.dto.people.PeopleSearchResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PeopleService {

    Page<PeopleDTO> getPeople(Pageable pageable);

    PeopleByIdResponseDTO getPeopleById(String id);

    PeopleSearchResponseDTO getPeopleByName(String name);
}

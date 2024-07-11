package com.challenge.starwarsapi.service;

import com.challenge.starwarsapi.dto.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PeopleService {

    Page<People> getPeople(Pageable pageable);
    People getPeopleById(String id);
    People getPeopleByName(String name);
}

package com.challenge.starwarsapi.service.impl;

import com.challenge.starwarsapi.client.PeopleClient;
import com.challenge.starwarsapi.model.dto.people.PeopleByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.people.PeopleDTO;
import com.challenge.starwarsapi.model.dto.people.PeopleResponseDTO;
import com.challenge.starwarsapi.model.dto.people.PeopleSearchResponseDTO;
import com.challenge.starwarsapi.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService {


    private final PeopleClient peopleClient;

    /*public Page<People> getPeople(Pageable pageable) {
        Page<People> personPage = peopleClient.getPeople(pageable);
        return new PageImpl<>(personPage.getContent(), pageable, personPage.getTotalElements());
    }*/

    public Page<PeopleDTO> getPeople(Pageable pageable) {
        int page = pageable.getPageNumber();
        int size = pageable.getPageSize();

        PeopleResponseDTO response = peopleClient.getPeople(page, size);

        List<PeopleDTO> people = response.getResults();
        int totalRecords = response.getTotalRecords();

        return new PageImpl<>(people, pageable, totalRecords);
    }

    public PeopleByIdResponseDTO getPeopleById(String id) {
         return peopleClient.getPeopleById(id);
    }

    public PeopleSearchResponseDTO getPeopleByName(String name) {
         return peopleClient.getPeopleByName(name);
    }
}

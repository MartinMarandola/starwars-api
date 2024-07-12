package com.challenge.starwarsapi.service.impl;

import com.challenge.starwarsapi.client.PeopleClient;
import com.challenge.starwarsapi.dto.People;
import com.challenge.starwarsapi.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService {


    private final PeopleClient peopleClient;

    public Page<People> getPeople(Pageable pageable) {
        Page<People> personPage = peopleClient.getPeople(pageable);
        return new PageImpl<>(personPage.getContent(), pageable, personPage.getTotalElements());
    }

    public People getPeopleById(String id) {
         return peopleClient.getPeopleById(id);
    }

    public People getPeopleByName(String name) {
        //return null;
         return peopleClient.getPeopleByName(name);
    }
}

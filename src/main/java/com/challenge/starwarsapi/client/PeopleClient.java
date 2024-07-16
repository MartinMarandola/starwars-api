package com.challenge.starwarsapi.client;

import com.challenge.starwarsapi.model.dto.people.PeopleByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.people.PeopleResponseDTO;
import com.challenge.starwarsapi.model.dto.people.PeopleSearchResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "peopleClient", url = "https://www.swapi.tech/api", path = "/people")
public interface PeopleClient {

    @GetMapping
    PeopleResponseDTO getPeople(@RequestParam("page") int page, @RequestParam("limit") int limit);

    @GetMapping("/{id}")
    PeopleByIdResponseDTO getPeopleById(@PathVariable("id") String id);

    @GetMapping
    PeopleSearchResponseDTO getPeopleByName(@RequestParam("name") String name);
}

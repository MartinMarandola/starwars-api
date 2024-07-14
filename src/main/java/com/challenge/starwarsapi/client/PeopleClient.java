package com.challenge.starwarsapi.client;

import com.challenge.starwarsapi.model.dto.PeopleByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.PeopleResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "peopleClient", url = "https://www.swapi.tech/api", path = "/people")
public interface PeopleClient {

    /*@GetMapping("/people")
    Page<People> getPeople(@SpringQueryMap Pageable pageable);*/

    @GetMapping
    PeopleResponseDTO getPeople(@RequestParam("page") int page, @RequestParam("size") int size);

    @GetMapping("/{id}")
    PeopleByIdResponseDTO getPeopleById(@PathVariable("id") String id);

    @GetMapping
    PeopleByIdResponseDTO getPeopleByName(@RequestParam("name") String name);

}

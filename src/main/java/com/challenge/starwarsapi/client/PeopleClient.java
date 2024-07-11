package com.challenge.starwarsapi.client;

import com.challenge.starwarsapi.dto.People;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "starWarsClient", url = "https://www.swapi.tech/api", path = "/people")
public interface PeopleClient {

    @GetMapping
    Page<People> getPeople(@SpringQueryMap Pageable pageable);

    @GetMapping("/{id}")
    People getPeopleById(@PathVariable String id);

    @GetMapping
    People getPeopleByName(@RequestParam String name);

}

package com.challenge.starwarsapi.controller;

import com.challenge.starwarsapi.dto.People;
import com.challenge.starwarsapi.service.PeopleService;
import com.challenge.starwarsapi.service.impl.PeopleServiceImpl;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PeopleController {


    private final PeopleServiceImpl peopleService;

    @GetMapping
    public ResponseEntity<Page<People>> getPeople(
            @RequestParam @PageableDefault(size = 10) Pageable pageable
    ) {
        //Page<People> people = peopleService.getPeople(pageable.getPageNumber(), pageable.getPageSize());
        //return ResponseEntity.ok(people);
        return ResponseEntity.ok(peopleService.getPeople(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<People> getPeopleById(@PathVariable String id) {
        People person = peopleService.getPeopleById(id);
        return ResponseEntity.ok(person);
    }

    @GetMapping("/search")
    public ResponseEntity<People> getPeopleByName(@RequestParam @NotNull String name) {
        People person = peopleService.getPeopleByName(name);
        return ResponseEntity.ok(person);
    }
}

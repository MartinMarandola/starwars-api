package com.challenge.starwarsapi.controller;

import com.challenge.starwarsapi.dto.People;
import com.challenge.starwarsapi.service.PeopleService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PeopleController {


    private final PeopleService peopleService;
    private static final Logger LOG = LoggerFactory.getLogger(PeopleController.class);

    @GetMapping
    public ResponseEntity<Page<People>> getPeople(
            @RequestParam @PageableDefault(size = 10) Pageable pageable
    ) {
        LOG.debug("Requested: getPeople()");
        return ResponseEntity.ok(peopleService.getPeople(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<People> getPeopleById(@PathVariable String id) {
        LOG.debug("Requested: getPeopleById()");
        People person = peopleService.getPeopleById(id);
        return ResponseEntity.ok(person);
    }

    @GetMapping("/search")
    public ResponseEntity<People> getPeopleByName(@RequestParam @NotNull String name) {
        People person = peopleService.getPeopleByName(name);
        return ResponseEntity.ok(person);
    }
}

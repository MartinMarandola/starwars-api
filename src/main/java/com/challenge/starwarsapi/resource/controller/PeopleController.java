package com.challenge.starwarsapi.resource.controller;

import com.challenge.starwarsapi.model.dto.people.PeopleByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.people.PeopleDTO;
import com.challenge.starwarsapi.model.dto.people.PeopleSearchResponseDTO;
import com.challenge.starwarsapi.resource.PeopleResource;
import com.challenge.starwarsapi.service.PeopleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/people")
@RequiredArgsConstructor
public class PeopleController implements PeopleResource {

    private final PeopleService peopleService;

    @GetMapping
    public ResponseEntity<Page<PeopleDTO>> getPeople(@PageableDefault(size = 10) Pageable pageable) {
        log.info("Requested: getPeople()");
        return ResponseEntity.ok(peopleService.getPeople(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeopleByIdResponseDTO> getPeopleById(@PathVariable("id") String id) {
        log.info("Requested: getPeopleById({}):", id);
        PeopleByIdResponseDTO person = peopleService.getPeopleById(id);
        return ResponseEntity.ok(person);
    }

    @GetMapping("/search")
    public ResponseEntity<PeopleSearchResponseDTO> getPeopleByName(@RequestParam("name") String name) {
        log.info("Requested: getPeopleByName({}):", name);
        PeopleSearchResponseDTO person = peopleService.getPeopleByName(name);
        return ResponseEntity.ok(person);
    }
}

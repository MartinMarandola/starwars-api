package com.challenge.starwarsapi.controller;

import com.challenge.starwarsapi.model.dto.PeopleByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.PeopleDTO;
import com.challenge.starwarsapi.service.PeopleService;
import jakarta.validation.constraints.NotNull;
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
public class PeopleController {


    private final PeopleService peopleService;

    @GetMapping
    public ResponseEntity<Page<PeopleDTO>> getPeople(
            @PageableDefault(size = 10) Pageable pageable
    ) {
        log.info("Requested: getPeople()");
        return ResponseEntity.ok(peopleService.getPeople(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeopleByIdResponseDTO> getPeopleById(@PathVariable String id) {
        log.info("Requested: getPeopleById()");
        PeopleByIdResponseDTO person = peopleService.getPeopleById(id);
        return ResponseEntity.ok(person);
    }

    @GetMapping("/search")
    public ResponseEntity<PeopleByIdResponseDTO> getPeopleByName(@RequestParam @NotNull String name) {
        PeopleByIdResponseDTO person = peopleService.getPeopleByName(name);
        return ResponseEntity.ok(person);
    }
}

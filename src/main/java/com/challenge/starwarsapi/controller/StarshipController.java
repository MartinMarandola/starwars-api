package com.challenge.starwarsapi.controller;

import com.challenge.starwarsapi.model.dto.starship.StarshipByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.starship.StarshipDTO;
import com.challenge.starwarsapi.model.dto.starship.StarshipSearchResponseDTO;
import com.challenge.starwarsapi.service.StarshipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/starships")
@RequiredArgsConstructor
public class StarshipController {

    public final StarshipService starshipService;

    @GetMapping
    public ResponseEntity<Page<StarshipDTO>> getStarships(@PageableDefault(size = 10) Pageable pageable) {
        log.info("Requested: getStarships()");
        return ResponseEntity.ok(starshipService.getStarships(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StarshipByIdResponseDTO> getStarshipById(@PathVariable("id") String id) {
        log.info("Requested: getStarshipById(): ID {}", id);
        StarshipByIdResponseDTO starship = starshipService.getStarshipById(id);
        return ResponseEntity.ok(starship);
    }

    @GetMapping("/search")
    public ResponseEntity<StarshipSearchResponseDTO> getStarshipByName(@RequestParam("name") String name) {
        log.info("Requested: getStarshipByName(): {}", name);
        StarshipSearchResponseDTO person = starshipService.getStarshipByName(name);
        return ResponseEntity.ok(person);
    }
}

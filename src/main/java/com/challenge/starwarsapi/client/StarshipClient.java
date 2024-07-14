package com.challenge.starwarsapi.client;


import com.challenge.starwarsapi.model.dto.starship.StarshipByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.starship.StarshipResponseDTO;
import com.challenge.starwarsapi.model.dto.starship.StarshipSearchResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "starshipClient", url = "https://www.swapi.tech/api", path = "/starships")
public interface StarshipClient {

    @GetMapping
    StarshipResponseDTO getStarships(@RequestParam("page") int page, @RequestParam("size") int size);

    @GetMapping("/{id}")
    StarshipByIdResponseDTO getStarshipById(@PathVariable("id") String id);

    @GetMapping
    StarshipSearchResponseDTO getStarshipByName(@RequestParam("name") String name);
}

package com.challenge.starwarsapi.service;

import com.challenge.starwarsapi.model.dto.starship.StarshipByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.starship.StarshipDTO;
import com.challenge.starwarsapi.model.dto.starship.StarshipSearchResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StarshipService {

    Page<StarshipDTO> getStarships(Pageable pageable);

    StarshipByIdResponseDTO getStarshipById(String id);

    StarshipSearchResponseDTO getStarshipByName(String name);
}

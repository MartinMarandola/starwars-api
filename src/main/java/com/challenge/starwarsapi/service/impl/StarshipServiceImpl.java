package com.challenge.starwarsapi.service.impl;

import com.challenge.starwarsapi.client.StarshipClient;
import com.challenge.starwarsapi.model.dto.starship.StarshipByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.starship.StarshipDTO;
import com.challenge.starwarsapi.model.dto.starship.StarshipResponseDTO;
import com.challenge.starwarsapi.model.dto.starship.StarshipSearchResponseDTO;
import com.challenge.starwarsapi.service.StarshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StarshipServiceImpl implements StarshipService {

    private final StarshipClient starshipClient;

    @Override
    public Page<StarshipDTO> getStarships(Pageable pageable) {
        int page = pageable.getPageNumber();
        int size = pageable.getPageSize();

        StarshipResponseDTO response = starshipClient.getStarships(page, size);

        List<StarshipDTO> people = response.getResults();
        int totalRecords = response.getTotalRecords();

        return new PageImpl<>(people, pageable, totalRecords);
    }

    @Override
    public StarshipByIdResponseDTO getStarshipById(String id) {
        return starshipClient.getStarshipById(id);
    }

    @Override
    public StarshipSearchResponseDTO getStarshipByName(String name) {
        return starshipClient.getStarshipByName(name);
    }
}

package com.challenge.starwarsapi.service.impl;

import com.challenge.starwarsapi.client.StarshipClient;
import com.challenge.starwarsapi.model.dto.starship.StarshipByIdResponseDTO;
import com.challenge.starwarsapi.model.dto.starship.StarshipDTO;
import com.challenge.starwarsapi.model.dto.starship.StarshipResponseDTO;
import com.challenge.starwarsapi.model.dto.starship.StarshipSearchResponseDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class StarshipServiceImplTests {

    @Mock
    private StarshipClient starshipClient;

    private StarshipServiceImpl starshipService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        starshipService = new StarshipServiceImpl(starshipClient);
    }

    @Test
    public void testGetStarships() {

        StarshipResponseDTO mockResponse = new StarshipResponseDTO();
        mockResponse.setResults(Collections.emptyList());
        mockResponse.setTotalRecords(0);
        when(starshipClient.getStarships(anyInt(), anyInt())).thenReturn(mockResponse);
        Page<StarshipDTO> result = starshipService.getStarships(PageRequest.of(0, 10));
        assertEquals(0, result.getTotalElements());
        assertEquals(0, result.getContent().size());
    }

    @Test
    public void testGetStarshipById() {

        StarshipByIdResponseDTO mockResponse = new StarshipByIdResponseDTO();
        when(starshipClient.getStarshipById("1")).thenReturn(mockResponse);
        StarshipByIdResponseDTO result = starshipService.getStarshipById("1");
        assertEquals(mockResponse, result);
    }

    @Test
    public void testGetStarshipByName() {

        StarshipSearchResponseDTO mockResponse = new StarshipSearchResponseDTO();
        when(starshipClient.getStarshipByName("Millennium Falcon")).thenReturn(mockResponse);
        StarshipSearchResponseDTO result = starshipService.getStarshipByName("Millennium Falcon");
        assertEquals(mockResponse, result);
    }
}

package com.challenge.starwarsapi.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.challenge.starwarsapi.client.PeopleClient;
import com.challenge.starwarsapi.model.dto.people.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PeopleServiceImplTests {

    @Mock
    private PeopleClient peopleClient;

    @InjectMocks
    private PeopleServiceImpl peopleService;

    private Pageable pageable;
    private PeopleResponseDTO peopleResponse;

    /**
     * Set People response DTO
     */
    @BeforeEach
    public void setup() {

        pageable = PageRequest.of(0, 10);
        PeopleDTO person1 = new PeopleDTO("1", "Luke Skywalker", "https://www.swapi.tech/api/people/1");
        PeopleDTO person2 = new PeopleDTO("2", "C-3PO", "https://www.swapi.tech/api/people/2");
        List<PeopleDTO> peopleList = Arrays.asList(person1, person2);
        peopleResponse = new PeopleResponseDTO();
        peopleResponse.setResults(peopleList);
        peopleResponse.setTotalRecords(2);

    }

    @Test
    public void testGetPeople() {
        when(peopleClient.getPeople(0, 10)).thenReturn(peopleResponse);

        Page<PeopleDTO> result = peopleService.getPeople(pageable);

        assertEquals(2, result.getTotalElements());
        assertEquals(2, result.getContent().size());

    }

    @Test
    public void testGetPeopleById() {
        String id = "1";
        PeopleByIdResponseDTO expectedResponse = createInstanceForId(id);
        when(peopleClient.getPeopleById(id)).thenReturn(expectedResponse);

        PeopleByIdResponseDTO result = peopleService.getPeopleById(id);

        assertNotNull(result);
        assertEquals(expectedResponse.getResult().getUid(), result.getResult().getUid());
        assertEquals(expectedResponse.getResult().getProperties().getName(), result.getResult().getProperties().getName());
        assertEquals(expectedResponse.getResult().getProperties().getHeight(), result.getResult().getProperties().getHeight());
        assertEquals(expectedResponse, result);
    }

    @Test
    public void testGetPeopleByName() {
        String name = "Luke";
        PeopleSearchResponseDTO expectedResult = createInstanceForName();
        when(peopleClient.getPeopleByName(name)).thenReturn(expectedResult);

        PeopleSearchResponseDTO result = peopleService.getPeopleByName(name);

        assertEquals(expectedResult, result);
    }

    private static PeopleByIdResponseDTO createInstanceForId(String id) {
        PeopleByIdResponseDTO dto = new PeopleByIdResponseDTO();
        PeopleResultDTO result = new PeopleResultDTO();
        PeoplePropertiesDTO properties = new PeoplePropertiesDTO();
        properties.setHeight("172");
        properties.setMass("77");
        properties.setHair_color("blond");
        properties.setSkin_color("fair");
        properties.setEye_color("blue");
        properties.setBirth_year("19BBY");
        properties.setGender("male");
        properties.setCreated("2024-07-15T03:07:41.575Z");
        properties.setEdited("2024-07-15T03:07:41.575Z");
        properties.setName("Luke Skywalker");
        properties.setHomeworld("https://www.swapi.tech/api/planets/1");
        properties.setUrl("https://www.swapi.tech/api/people/1");

        result.setProperties(properties);
        result.setDescription("A person within the Star Wars universe");
        result.set_id("5f63a36eee9fd7000499be42");
        result.setUid(id);
        result.set__v(0);

        dto.setResult(result);
        return dto;
    }

    public static PeopleSearchResponseDTO createInstanceForName() {
        PeopleSearchResponseDTO dto = new PeopleSearchResponseDTO();
        List<PeopleResultDTO> resultList = List.of(
                createPeopleResult()
        );
        dto.setResult(resultList);
        return dto;
    }

    private static PeopleResultDTO createPeopleResult() {
        PeopleResultDTO result = new PeopleResultDTO();
        PeoplePropertiesDTO properties = new PeoplePropertiesDTO();
        properties.setHeight("172");
        properties.setMass("77");
        properties.setHair_color("blond");
        properties.setSkin_color("fair");
        properties.setEye_color("blue");
        properties.setBirth_year("19BBY");
        properties.setGender("male");
        properties.setCreated("2024-07-15T03:07:41.575Z");
        properties.setEdited("2024-07-15T03:07:41.575Z");
        properties.setName("Luke");
        properties.setHomeworld("https://www.swapi.tech/api/planets/1");
        properties.setUrl("https://www.swapi.tech/api/people/" + "1");

        result.setProperties(properties);
        result.setDescription("A person within the Star Wars universe");
        result.set_id("12");
        result.setUid("1");
        result.set__v(0);

        return result;
    }
}


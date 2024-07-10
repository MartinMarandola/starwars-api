package com.challenge.starwarsapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "starWarsClient", url = "https://www.swapi.tech/api")
public interface StarWarsClient {

    
}

package com.example.recipt_website_project.service.impl;

import com.example.recipt_website_project.service.EdamamApiService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EdamamApiServiceImpl implements EdamamApiService {

    private final RestTemplate restTemplate;
    private final String apiUrl = "https://api.edamam.com/api/recipes/v2";

    public EdamamApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String callEdamamApi() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Application-Id", "54d4ac0c");
        headers.set("Application-Key", "7ff8eb14b0e29e7e13d6f3797f69b5e3");

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                request,
                String.class
        );


        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to call the Edamam API");
        }
    }
}

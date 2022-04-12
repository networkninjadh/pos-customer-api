package com.howtech.poscustomerapi.clients;

import java.util.Arrays;
import java.util.List;

import com.howtech.poscustomerapi.models.StoreDto;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StoreClient {
    private RestTemplate restTemplate;

    private String URL = "http://localhost:8083";
    private String FIND_ALL = "/store-api/stores";
    private String STORE = "/store-api/store/";

    public StoreClient() {
        restTemplate = new RestTemplate();
    }

    public List<StoreDto> findAll() {
        ResponseEntity<StoreDto[]> response = restTemplate
                .getForEntity(URL + FIND_ALL, StoreDto[].class);
        return Arrays.asList(response.getBody());
    }

    public StoreDto findById(Long storeId) {
        ResponseEntity<StoreDto> response = restTemplate
                .getForEntity(URL + STORE + storeId, StoreDto.class);
        return response.getBody();

    }
}

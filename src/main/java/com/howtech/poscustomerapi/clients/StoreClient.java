package com.howtech.poscustomerapi.clients;

import com.howtech.poscustomerapi.models.StoreDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class StoreClient {
    private final RestTemplate restTemplate;

    private final String URL = "http://localhost:8083";
    private final String FIND_ALL = "/store-api/stores";
    private final String STORE = "/store-api/store/";

    public StoreClient() {
        restTemplate = new RestTemplate();
    }

    public List<StoreDto> findAll() {
        ResponseEntity<StoreDto[]> response = restTemplate
                .getForEntity(URL + FIND_ALL, StoreDto[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public StoreDto findById(Long storeId) {
        ResponseEntity<StoreDto> response = restTemplate
                .getForEntity(URL + STORE + storeId, StoreDto.class);
        return response.getBody();

    }
}

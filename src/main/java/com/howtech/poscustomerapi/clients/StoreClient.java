package com.howtech.poscustomerapi.clients;

import com.howtech.poscustomerapi.models.StoreDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class StoreClient {

    private final Logger LOGGER = LoggerFactory.getLogger(StoreClient.class);

    private final RestTemplate restTemplate = new RestTemplate();

    private final String URL = "http://localhost:8083";

    public StoreClient() {}

    public List<StoreDto> findAll() {
        LOGGER.info("StoreClient: Retrieve a list of all Stores for a Customer");
        String FIND_ALL = "/store-api/stores";
        ResponseEntity<StoreDto[]> response = restTemplate
                .getForEntity(URL + FIND_ALL, StoreDto[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public StoreDto findById(Long storeId) {
        String STORE = "/store-api/store/";
        ResponseEntity<StoreDto> response = restTemplate
                .getForEntity(URL + STORE + storeId, StoreDto.class);
        return response.getBody();

    }
}

package com.howtech.poscustomerapi.services;

import java.util.List;

import com.howtech.poscustomerapi.clients.StoreClient;
import com.howtech.poscustomerapi.models.StoreDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    private final Logger LOGGER = LoggerFactory.getLogger(StoreService.class);

    private final StoreClient storeClient;

    public StoreService(StoreClient storeClient) {
        this.storeClient = storeClient;
    }

    public StoreDto getById(Long storeId) {
        LOGGER.info("StoreClient: Retrieve a Store by ID for a Customer");
        return storeClient.findById(storeId);
    }

    public List<StoreDto> getAll() {
        LOGGER.info("StoreClient: Retrieve a list of all Stores for a Customer");
        return storeClient.findAll();
    }

}

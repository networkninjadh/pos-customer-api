package com.howtech.poscustomerapi.services;

import java.util.List;

import com.howtech.poscustomerapi.clients.StoreClient;
import com.howtech.poscustomerapi.models.StoreDto;

import org.springframework.stereotype.Service;

@Service
public class StoreService {

    private final StoreClient storeClient;

    public StoreService(StoreClient storeClient) {
        this.storeClient = storeClient;
    }

    public StoreDto getById(Long storeId) {
        return storeClient.findById(storeId);
    }

    public List<StoreDto> getAll() {
        return storeClient.findAll();
    }

}

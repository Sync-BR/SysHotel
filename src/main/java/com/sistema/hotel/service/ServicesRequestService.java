package com.sistema.hotel.service;

import com.sistema.hotel.model.service.entities.RequestServiceEntities;
import com.sistema.hotel.repository.RequestServiceRepository;
import com.sistema.hotel.service.abstractions.ServiceRequestInterface;
import com.sistema.hotel.util.validate.ValidateServices;
import org.springframework.stereotype.Service;

@Service
public class ServicesRequestService implements ServiceRequestInterface {
    private final RequestServiceRepository repository;
    private ValidateServices serviceValidator;

    public ServicesRequestService(RequestServiceRepository repository, ValidateServices serviceValidator) {
        this.repository = repository;
        this.serviceValidator = serviceValidator;
    }


    @Override
    public void save(RequestServiceEntities entities) {
        serviceValidator.checkSave(repository.save(entities));
    }
}

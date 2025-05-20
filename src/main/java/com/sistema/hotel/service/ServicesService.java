package com.sistema.hotel.service;

import com.sistema.hotel.model.service.entities.ServiceEntities;
import com.sistema.hotel.repository.ServicesRepository;
import com.sistema.hotel.service.abstractions.ServiceHotelInterface;
import com.sistema.hotel.util.validate.ValidateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService implements ServiceHotelInterface {
    @Autowired
    private ServicesRepository repository;
    private final ValidateServices validate;

    public ServicesService() {
        validate = new ValidateServices();
    }

    public List<ServiceEntities> getAllServices() {
        return repository.findAll();
    }

    @Override
    public void save(ServiceEntities service) {
        validate.checkDateSaved(repository.save(service));
    }

    @Override
    public void update(ServiceEntities service) {

    }

    @Override
    public void disable(ServiceEntities service) {

    }
}

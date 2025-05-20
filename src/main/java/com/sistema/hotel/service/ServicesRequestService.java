package com.sistema.hotel.service;

import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.model.service.entities.RequestServiceEntities;
import com.sistema.hotel.repository.RequestServiceRepository;
import com.sistema.hotel.service.abstractions.ServiceRequestInterface;
import com.sistema.hotel.util.PermissionValidate;
import com.sistema.hotel.util.validate.ValidateServices;
import com.sistema.hotel.util.validate.ValidatorClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesRequestService implements ServiceRequestInterface {
    private final RequestServiceRepository repository;
    private final ValidateServices serviceValidator;
    private final ValidatorClientService validateClient;


    public ServicesRequestService(RequestServiceRepository repository, ValidateServices serviceValidator, ValidatorClientService validateClient) {
        this.repository = repository;
        this.serviceValidator = serviceValidator;
        this.validateClient = validateClient;
    }

    @Override
    public void save(RequestServiceEntities entities) {
        entities.setClient(validateClient.checkClientCpf(entities.getClient()));
        entities.setService(serviceValidator.checkServiceExists(entities.getService()));
        repository.save(entities);

    }

    @Override
    public List<RequestServiceEntities> responseListServicesRequest(ClientEntities client) {
        PermissionValidate permissionValidate = new PermissionValidate();
        if(!permissionValidate.checkPermissionDev(client)){
            throw new ClientException("O Usuário informado não possuir nivel maximo de permissão");
        }
        return repository.findByIsActive(true);
    }
}

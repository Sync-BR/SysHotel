package com.sistema.hotel.controller.service;

import com.sistema.hotel.controller.service.interfaces.ClientServiceInterface;
import com.sistema.hotel.controller.service.util.ValidatorService;
import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService  implements ClientServiceInterface {
    private final ValidatorService validate;
    protected ClientRepository clientRepository;

    public ClientService(ValidatorService validate, ClientRepository clientRepository) {
        this.validate = validate;
        this.clientRepository = clientRepository;
    }

    @Override
    public void saveClient(ClientEntities newClient) {
        if (validate.checkDate(newClient)) {
            validate.checkSaveClient(clientRepository.save(newClient));
        }
    }

    @Override
    public boolean disableClient(int idClient) {
        return false;
    }

    @Override
    public ClientEntities updateClient(ClientEntities clientUpdate) {
        return null;
    }
}

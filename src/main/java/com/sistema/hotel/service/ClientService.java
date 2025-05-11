package com.sistema.hotel.service;

import com.sistema.hotel.service.abstractions.ClientServiceInterface;
import com.sistema.hotel.util.validate.ValidatorClientService;
import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService  implements ClientServiceInterface {
    private final ValidatorClientService validate;
    protected ClientRepository clientRepository;

    public ClientService(ValidatorClientService validate, ClientRepository clientRepository) {
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

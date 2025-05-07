package com.sistema.hotel.controller.service;

import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.model.client.entities.ClientEntities;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final ClientService clientService;

    public UserService(ClientService clientService) {
        this.clientService = clientService;
    }

    public void addClient(ClientEntities client) throws ClientException {
         clientService.saveUser(client);
    }

}

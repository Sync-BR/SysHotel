package com.sistema.hotel.controller.service;

import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    private boolean checkDate(ClientEntities dateCheck) throws ClientException {
        if (checkClientCpf(dateCheck.getCpf()) != null)
            throw new ClientException("O CPF informado já está cadastrado.");

        if (checkClientEmail(dateCheck.getEmail()) != null)
            throw new ClientException("O e-mail informado já está em uso.");

        if (checkClientUsername(dateCheck.getDateUser().getUsername()) != null)
            throw new ClientException("O nome de usuário escolhido já está em uso.");

        return true;
    }


    public ClientEntities checkClientCpf(String cpf) {
        return repository.findClientEntitiesByCpf(cpf);
    }

    public ClientEntities checkClientEmail(String email) {
        return repository.findClientEntitiesByEmail(email);
    }

    public ClientEntities checkClientUsername(String username) {
        return repository.findClientEntitiesByDateUser_Username(username);
    }


    public void saveUser(ClientEntities client) {
        if (checkDate(client)) {
            repository.save(client);
        }
    }
}

package com.sistema.hotel.controller.service;

import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.model.client.entities.UserEntities;
import com.sistema.hotel.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final ClientService clientService;
    private final UserRepository userRepository;

    public UserService(ClientService clientService, UserRepository userRepository) {
        this.clientService = clientService;
        this.userRepository = userRepository;
    }

    private UserEntities findByUser(String userSearch) throws ClientException {
        UserEntities user = userRepository.findByUsername(userSearch);
        if (user == null) {
            throw new ClientException("Nenhum usuário correspondente foi encontrado.");
        }
        return user;
    }

    public void addClient(ClientEntities client) throws ClientException {
        clientService.saveUser(client);
    }

    public ClientEntities Login(UserEntities user) {
            return findByUser(user.getUsername()).getClient();

    }

}

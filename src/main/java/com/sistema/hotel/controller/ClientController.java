package com.sistema.hotel.controller;

import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.model.client.dto.ClientDto;
import com.sistema.hotel.service.ClientService;
import com.sistema.hotel.util.mapper.UserMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/client")
@RestController
public class ClientController {
    private final ClientService clientService;
    private final UserMapper userMapper;

    public ClientController(ClientService clientService, UserMapper userMapper) {
        this.clientService = clientService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody @Valid ClientDto client) {
        try {
            clientService.saveClient(userMapper.dtoToEntity(client));
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário registrado com sucesso.");
        } catch (ClientException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}

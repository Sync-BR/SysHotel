package com.sistema.hotel.controller;

import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.model.client.dto.ClientDto;
import com.sistema.hotel.service.ClientService;
import com.sistema.hotel.util.mapper.UserMapper;
import com.sistema.hotel.util.validate.ValidateUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/client")
@RestController
public class ClientController {
    private final UserMapper userMapper;
    private final ClientService clientService;
    private final ValidateUserService validateUser;

    public ClientController(UserMapper userMapper, ClientService clientService, ValidateUserService validateUser) {
        this.userMapper = userMapper;
        this.clientService = clientService;
        this.validateUser = validateUser;
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

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody @Valid ClientDto client) {
        try {
            validateUser.checkIsLoggedIn(userMapper.dtoToEntity(client).getDateUser(), client.getClientUser().getPassword());
            return ResponseEntity.status(HttpStatus.OK).body(userMapper.entityToDto(clientService.updateClient(userMapper.dtoToEntity(client))));
        } catch (ClientException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> disableAccount(@RequestBody @Valid ClientDto client) {
        try {
            validateUser.checkIsLoggedIn(userMapper.dtoToEntity(client).getDateUser(), client.getClientUser().getPassword());
            clientService.disableClient(userMapper.disableAccount(userMapper.dtoToEntity(client)));
            return ResponseEntity.status(HttpStatus.OK).body("Conta desativada com sucesso.");
        } catch (ClientException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}

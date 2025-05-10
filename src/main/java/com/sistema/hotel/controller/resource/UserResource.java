package com.sistema.hotel.controller.resource;

import com.sistema.hotel.controller.service.UserService;
import com.sistema.hotel.controller.service.util.PasswordUtil;
import com.sistema.hotel.controller.service.util.UserMapper;
import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.model.client.dto.ClientDto;

import com.sistema.hotel.model.client.dto.UserDto;
import com.sistema.hotel.model.client.entities.ClientEntities;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@Validated
public class UserResource {
    private final UserService userService;
    private final UserMapper userMapper;
    private final PasswordUtil encryptPassword;

    public UserResource(UserService userService, UserMapper userMapper, PasswordUtil encryptPassword) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.encryptPassword = encryptPassword;
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody @Valid ClientDto client) {
        try {
            userService.addClient(userMapper.dtoToEntity(client));
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário registrado com sucesso.");
        } catch (ClientException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserDto user) {
        try {
            ClientEntities searchClient = userService.Login(userMapper.userDtoToEntity(user));
            if (encryptPassword.checkPassword(user.getPassword(), searchClient.getDateUser().getPassword())) {
                return ResponseEntity.status(HttpStatus.OK).body(userMapper.entityToDto(searchClient));
            }
        } catch (ClientException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("A senha informada está incorreta. Tente novamente.");


    }


}

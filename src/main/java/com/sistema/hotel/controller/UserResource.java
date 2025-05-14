package com.sistema.hotel.controller;

import com.sistema.hotel.service.UserService;
import com.sistema.hotel.util.validate.ValidateUserService;
import com.sistema.hotel.util.mapper.UserMapper;
import com.sistema.hotel.exception.ClientException;

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
    private final UserMapper userMapper;
    private final UserService userService;
    private final ValidateUserService validateUser;

    public UserResource(UserMapper userMapper, UserService userService, ValidateUserService validateUser) {
        this.userMapper = userMapper;
        this.userService = userService;
        this.validateUser = validateUser;
    }

    @PostMapping()
    public ResponseEntity<?> login(@RequestBody @Valid UserDto user) {
        try {
            ClientEntities searchClient = userService.authenticateUser(userMapper.userDtoToEntity(user));
            validateUser.authenticateUser(searchClient.getDateUser(), user);
            return ResponseEntity.status(HttpStatus.OK).body(userMapper.entityToDto(searchClient));

        } catch (ClientException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

    }


}

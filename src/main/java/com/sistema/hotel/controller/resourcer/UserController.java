package com.sistema.hotel.controller.resourcer;

import com.sistema.hotel.controller.service.UserService;
import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.model.client.dto.ClientDto;

import com.sistema.hotel.util.userUtil.UserUtil;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@Validated
public class UserController extends UserUtil {
    private final UserService userService;


    public UserController(PasswordEncoder passwordEncoder, UserService userService) {
        super(passwordEncoder);
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody @Valid ClientDto client) {
        try {
            userService.addClient(convertDtoToEntities(client));
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário registrado com sucesso.");
        } catch (ClientException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }


}

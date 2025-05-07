package com.sistema.hotel.controller.resourcer;

import com.sistema.hotel.controller.service.UserService;
import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.model.client.dto.ClientDto;

import com.sistema.hotel.model.client.dto.UserDto;
import com.sistema.hotel.model.client.entities.ClientEntities;
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
public class UserResource extends UserUtil {
    private final UserService userService;


    public UserResource(PasswordEncoder passwordEncoder, UserService userService) {
        super(passwordEncoder);
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody @Valid ClientDto client) {
        try {
            userService.addClient(convertDtoToEntities(client));
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário registrado com sucesso.");
        } catch (ClientException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserDto user) {
        try {
            ClientEntities searchClient = userService.Login(covertUser(user));
            if (checkPassword(user.getPassword(), searchClient.getDateUser().getPassword())) {
                return ResponseEntity.status(HttpStatus.OK).body(convertEntitiesToDto(searchClient));
            }
        } catch (ClientException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("A senha informada está incorreta. Tente novamente.");


    }


}

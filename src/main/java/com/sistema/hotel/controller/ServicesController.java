package com.sistema.hotel.controller;

import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.exception.ServicesException;
import com.sistema.hotel.model.service.dto.ServicesDto;
import com.sistema.hotel.service.ServicesService;
import com.sistema.hotel.util.mapper.ServiceMapper;
import com.sistema.hotel.util.mapper.UserMapper;
import com.sistema.hotel.util.validate.ValidateUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services")
@Validated
public class ServicesController {

    private final ServicesService service;
    private final ServiceMapper mapper;
    private final ValidateUserService validateUser;
    private final UserMapper userMapper;

    public ServicesController(ServicesService service, ServiceMapper mapper, ValidateUserService validateUser, UserMapper userMapper) {
        this.service = service;
        this.mapper = mapper;
        this.validateUser = validateUser;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<?> getAllServices() {
        if (service.getAllServices().isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return new ResponseEntity<>(mapper.convertToDto(service.getAllServices()), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<?> createService(@RequestBody @Valid ServicesDto dto) {
        try {
            validateUser.checkIsLoggedIn(userMapper.userDtoToEntity(dto.getClient().getClientUser()),
                    dto.getClient().getClientUser().getPassword());
            service.save(mapper.convertToEntity(dto));
            return ResponseEntity.status(HttpStatus.CREATED).body("Serviço adicionado com sucesso!");
        } catch (ServicesException | ClientException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

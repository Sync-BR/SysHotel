package com.sistema.hotel.controller;

import com.sistema.hotel.service.RoomService;
import com.sistema.hotel.util.mapper.RoomMapper;
import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.exception.RoomException;
import com.sistema.hotel.model.room.dto.RoomDto;
import com.sistema.hotel.util.mapper.UserMapper;
import com.sistema.hotel.util.validate.ValidateUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rooms")
@RestController
@Validated
public class RoomResource  {
    private final RoomService service;
    private final  RoomMapper mapper;
    private final ValidateUserService validateUser;
    private final UserMapper userMapper;

    public RoomResource(RoomService service, RoomMapper mapper, ValidateUserService validateUser, UserMapper userMapper) {
        this.service = service;
        this.mapper = mapper;
        this.validateUser = validateUser;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<?> addRoom(@RequestBody @Valid RoomDto room) {
        try{
            room = mapper.convertLatterToUpperCase(room);
            validateUser.checkIsLoggedIn(userMapper.userDtoToEntity(room.getClient().getClientUser()), room.getClient().getClientUser().getUsername());
            service.saveRoom(mapper.covertEntitiesRoom(room));
            return ResponseEntity.status(HttpStatus.CREATED).body("O Quarto foi adicionado com sucesso ao sistema.");
        } catch (ClientException | RoomException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

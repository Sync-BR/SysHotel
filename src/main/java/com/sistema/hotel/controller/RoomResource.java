package com.sistema.hotel.controller;

import com.sistema.hotel.service.RoomService;
import com.sistema.hotel.util.mapper.RoomMapper;
import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.exception.RoomException;
import com.sistema.hotel.model.room.dto.RoomDto;
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
    private final RoomMapper mapper;

    public RoomResource(RoomService service, RoomMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<?> addRoom(@RequestBody @Valid RoomDto room) {
        try{
            room = mapper.convertLatterToUpperCase(room);
            service.saveRoom(mapper.covertEntitiesRoom(room));
            return ResponseEntity.status(HttpStatus.CREATED).body("O Quarto foi adicionado com sucesso ao sistema.");
        } catch (ClientException | RoomException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

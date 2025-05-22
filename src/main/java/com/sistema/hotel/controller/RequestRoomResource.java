package com.sistema.hotel.controller;


import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.exception.RoomException;
import com.sistema.hotel.model.room.dto.RequestRoomDto;
import com.sistema.hotel.model.room.dto.RoomDto;
import com.sistema.hotel.service.RequestRoomService;
import com.sistema.hotel.util.mapper.RequestRoomMapper;
import com.sistema.hotel.util.mapper.UserMapper;
import com.sistema.hotel.util.validate.ValidateRequestRoom;
import com.sistema.hotel.util.validate.ValidateUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/request/room")
public class RequestRoomResource {
    private final ValidateUserService validateUser;
    private final ValidateRequestRoom validateRequestRoom;
    private final UserMapper userMapper;
    private final RequestRoomMapper requestRoomMapper;
    private final RequestRoomService service;


    public RequestRoomResource(ValidateUserService validateUser, ValidateRequestRoom validateRequestRoom, UserMapper userMapper, RequestRoomMapper requestRoomMapper, RequestRoomService requestRoomService) {
        this.validateUser = validateUser;
        this.validateRequestRoom = validateRequestRoom;
        this.userMapper = userMapper;
        this.requestRoomMapper = requestRoomMapper;
        this.service = requestRoomService;
    }

    @PostMapping
    public ResponseEntity<?> requestRoom(@RequestBody @Valid RoomDto dto) {
        try {
            validateUser.checkIsLoggedIn(userMapper.userDtoToEntity(dto.getClient().getClientUser()), dto.getClient().getClientUser().getPassword());
            validateRequestRoom.checkAvailability(requestRoomMapper.convertToEntity(dto));
            // Buscar pelo andar, número do quarto e a lettrar
            service.save(requestRoomMapper.convertToEntity(dto));
            return ResponseEntity.status(HttpStatus.OK).body("Quarto alugado com sucesso");
        } catch (ClientException | RoomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


//    @PostMapping("/neighbors")
//    public ResponseEntity<?> nextNeighbors(@RequestBody @Valid RoomDto room) {
//        validateUser.checkIsLoggedIn(userMapper.userDtoToEntity(room.getClient().getClientUser()), room.getClient().getClientUser().getPassword());
//
//        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//    }

}

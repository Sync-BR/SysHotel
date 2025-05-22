package com.sistema.hotel.service;

import com.sistema.hotel.model.room.dto.RoomDto;
import com.sistema.hotel.util.mapper.RoomMapper;
import com.sistema.hotel.util.validate.ValidateRoomService;
import com.sistema.hotel.exception.RoomException;
import com.sistema.hotel.model.room.entities.RoomEntities;
import com.sistema.hotel.service.abstractions.RoomServiceInterface;
import com.sistema.hotel.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements RoomServiceInterface {
    private final ValidateRoomService validator;
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomService(ValidateRoomService validator, RoomRepository roomRepository, RoomMapper roomMapper) {
        this.validator = validator;
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }
    public RoomEntities getRoom(int numberRoom, char numberLetter, int roomLevel) {
        return roomRepository.findRoomEntitiesByNumberRoomAndNumberLetterAndRoomLevel(numberRoom, numberLetter, roomLevel);
    }


    @Override
    public void saveRoom(RoomEntities room) throws RoomException {
        if (validator.checkAvailability(room.getNumberRoom(), room.getNumberLetter(), room.getRoomLevel())) {
            validator.checkRoomSaved(roomRepository.save(room));
        }
    }

    @Override
    public boolean deleteRoom(int roomId) {
        return false;
    }

    @Override
    public RoomEntities updateRoom(RoomEntities room) {
        return null;
    }


}

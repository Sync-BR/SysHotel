package com.sistema.hotel.controller.service;

import com.sistema.hotel.controller.service.util.ValidatorService;
import com.sistema.hotel.exception.RoomException;
import com.sistema.hotel.model.room.entities.RoomEntities;
import com.sistema.hotel.controller.service.interfaces.RoomServiceInterface;
import com.sistema.hotel.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService implements RoomServiceInterface {
    private final ValidatorService validator;
    private final RoomRepository roomRepository;
    public RoomService(ValidatorService validator, RoomRepository roomRepository) {
        this.validator = validator;
        this.roomRepository = roomRepository;
    }


    @Override
    public void saveRoom(RoomEntities room) throws RoomException {
        if (validator.checkAvailability(room.getNumberRoom(), room.getNumberLetter())) {
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

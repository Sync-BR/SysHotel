package com.sistema.hotel.util.validate;

import com.sistema.hotel.exception.RoomException;
import com.sistema.hotel.exception.interfaces.RoomExceptionInterface;
import com.sistema.hotel.model.room.entities.RoomEntities;
import com.sistema.hotel.repository.RoomRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidateRoomService implements RoomExceptionInterface {
    private final RoomRepository roomRepository;

    public ValidateRoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void checkRoomSaved(RoomEntities room) throws RoomException {
        if (room.getId() == 0) {
            throw new RoomException("Erro ao tentar adicionar um quarto. Verifique os dados e tente novamente.");
        }
    }

    @Override
    public void checkRoomAvailability(RoomEntities room) throws RoomException {
        if (room != null) {
            throw new RoomException("Já existe uma sala com essas informações. Verifique os dados e tente novamente.");
        }
    }

    @Override
    public boolean checkAvailability(int numberRoom, char letterRoom) {
        if (roomRepository.findRoomEntitiesByNumberRoom(numberRoom) != null) {
            checkRoomAvailability(roomRepository.findRoomEntitiesByNumberRoomAndNumberLetter(numberRoom, letterRoom));
        }
        return true;
    }
}

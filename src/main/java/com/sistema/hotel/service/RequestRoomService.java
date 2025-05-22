package com.sistema.hotel.service;

import com.sistema.hotel.model.room.entities.RequestRoomEntities;
import com.sistema.hotel.repository.RequestRoomRepository;
import com.sistema.hotel.repository.RoomRepository;
import com.sistema.hotel.service.abstractions.RoomRequestService;
import com.sistema.hotel.util.validate.ValidateRequestRoom;
import com.sistema.hotel.util.validate.ValidateRoomService;
import org.springframework.stereotype.Service;

@Service
public class RequestRoomService implements RoomRequestService {
    private final RoomService serviceRoom;
    private final RequestRoomRepository repository;
    private final ValidateRequestRoom validate;
    private final ValidateRoomService validateRoom;
    public RequestRoomService(RoomService serviceRoom, RequestRoomRepository repository, ValidateRequestRoom validate, ValidateRoomService validateRoom) {
        this.serviceRoom = serviceRoom;
        this.repository = repository;
        this.validate = validate;
        this.validateRoom = validateRoom;
    }



    @Override
    public void save(RequestRoomEntities requestRoom) {

        requestRoom.setClient(validate.checkRentalLimit(requestRoom.getClient()));
        requestRoom.setRoom(validateRoom.checkRoomExists(serviceRoom.getRoom(requestRoom.getRoom().getNumberRoom(), requestRoom.getRoom().getNumberLetter(), requestRoom.getRoom().getRoomLevel())));
        validate.checkSaved(repository.save(requestRoom));
    }

    @Override
    public void update(RequestRoomEntities requestRoom) {

    }

    @Override
    public void delete(RequestRoomEntities requestRoom) {

    }
}

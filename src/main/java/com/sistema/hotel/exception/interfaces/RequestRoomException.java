package com.sistema.hotel.exception.interfaces;

import com.sistema.hotel.exception.RoomException;
import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.model.room.entities.RequestRoomEntities;

public interface RequestRoomException {
    ClientEntities checkRentalLimit(ClientEntities client) throws RoomException;
    void checkSaved(RequestRoomEntities requestRoom)throws RoomException;
    void checkAvailability(RequestRoomEntities requestEntity)  throws RoomException;
}

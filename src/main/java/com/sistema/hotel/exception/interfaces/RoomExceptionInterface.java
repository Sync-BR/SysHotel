package com.sistema.hotel.exception.interfaces;

import com.sistema.hotel.exception.RoomException;
import com.sistema.hotel.model.room.entities.RoomEntities;

public interface RoomExceptionInterface {
     RoomEntities checkRoomExists(RoomEntities room) throws RoomException;
     void checkRoomSaved(RoomEntities room) throws RoomException;
     void checkRoomAvailability(RoomEntities room) throws RoomException;
     boolean checkAvailability(int numberRoom, char letterRoom, int roomLevel);
}

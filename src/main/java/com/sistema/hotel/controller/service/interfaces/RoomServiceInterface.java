package com.sistema.hotel.controller.service.interfaces;

import com.sistema.hotel.model.room.entities.RoomEntities;

public interface RoomServiceInterface {
    void saveRoom(RoomEntities room);
    boolean deleteRoom(int roomId);
    RoomEntities updateRoom(RoomEntities room);
}

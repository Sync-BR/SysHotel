package com.sistema.hotel.service.abstractions;

import com.sistema.hotel.model.room.dto.RoomDto;
import com.sistema.hotel.model.room.entities.RoomEntities;

import java.util.List;

public interface RoomServiceInterface {
    void saveRoom(RoomEntities room);
    boolean deleteRoom(int roomId);
    RoomEntities updateRoom(RoomEntities room);

}

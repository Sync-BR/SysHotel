package com.sistema.hotel.service.abstractions;

import com.sistema.hotel.model.room.entities.RequestRoomEntities;

public interface RoomRequestService {

    void save(RequestRoomEntities requestRoom);
    void update(RequestRoomEntities requestRoom);
    void delete(RequestRoomEntities requestRoom);

}

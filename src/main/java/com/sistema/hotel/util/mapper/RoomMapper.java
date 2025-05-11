package com.sistema.hotel.util.mapper;

import com.sistema.hotel.model.room.dto.RoomDto;
import com.sistema.hotel.model.room.entities.RoomEntities;
import com.sistema.hotel.model.room.type.TypeRoom;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class RoomMapper {

    public RoomDto convertLatterToUpperCase(RoomDto roomDto) {
        roomDto.setLetter(roomDto.getLetter().toUpperCase());
        return roomDto;
    }

    public RoomEntities covertEntitiesRoom(RoomDto room){
        return  new RoomEntities(
                room.getImage().getBytes(StandardCharsets.UTF_8),
                room.getNumber(),
                room.getLevel(),
                room.getLetter().charAt(0),
                room.getCapacity(),
                room.getPrice(),
                room.isAvailable(),
                room.isSmoker(),
                room.isAccessibility(),
                room.getTitle(),
                room.getDescription(),
                TypeRoom.valueOf(room.getTypeRoom())
        );
    }

}

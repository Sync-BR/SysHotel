package com.sistema.hotel.util.mapper;

import com.sistema.hotel.model.room.dto.RoomDto;
import com.sistema.hotel.model.room.entities.RoomEntities;
import com.sistema.hotel.model.room.enumeration.TypeRoom;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoomMapper {

    public RoomDto convertLatterToUpperCase(RoomDto roomDto) {
        roomDto.setLetter(roomDto.getLetter().toUpperCase());
        return roomDto;
    }

    public List<RoomDto> convertListToDto(List<RoomEntities> roomEntities) {
        List<RoomDto> roomDtos = new ArrayList<>();
        for(RoomEntities entity : roomEntities){
        }
        return roomDtos;
    }


    public RoomDto convertDtoToRoom(RoomEntities entities) {
        return new RoomDto(
                entities.getNumberRoom(),
                entities.getRoomLevel(),
                entities.getCapacity(),
                entities.getPrice(),
                entities.isAvailable(),
                entities.isSmoker(),
                entities.isAccessibility(),
                String.valueOf(entities.getImage()),
                entities.getTitle(),
                entities.getDescription(),
                Character.toString(entities.getNumberLetter()),
                entities.getType().getType()
        );
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

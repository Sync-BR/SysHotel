package com.sistema.hotel.util.mapper;

import com.sistema.hotel.model.room.dto.RoomDto;
import com.sistema.hotel.model.room.entities.RoomEntities;
import com.sistema.hotel.model.room.enumeration.TypeRoom;
import com.sistema.hotel.util.Base64Util;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoomMapper {

    private final Base64Util base64Util;

    public RoomMapper(Base64Util base64Util) {
        this.base64Util = base64Util;
    }

    public RoomDto convertLatterToUpperCase(RoomDto roomDto) {
        roomDto.setLetter(roomDto.getLetter().toUpperCase());
        return roomDto;
    }

    public List<RoomDto> convertListToDto(List<RoomEntities> roomEntities) {
        List<RoomDto> roomDto = new ArrayList<>();
        for(RoomEntities entity : roomEntities){
            roomDto.add(new RoomDto(
                    entity.getNumberRoom(),
                    entity.getRoomLevel(),
                    entity.getCapacity(),
                    entity.getPrice(),
                    entity.isAvailable(),
                    entity.isSmoker(),
                    entity.isAccessibility(),
                    base64Util.encode(entity.getImage()),
                    entity.getTitle(),
                    entity.getDescription(),
                    Character.toString(entity.getNumberLetter()),
                    entity.getType().getType()
            ));
        }
        return roomDto;
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
                base64Util.encode(entities.getImage()),
                entities.getTitle(),
                entities.getDescription(),
                Character.toString(entities.getNumberLetter()),
                entities.getType().getType()
        );
    }

    public RoomEntities covertEntitiesRoom(RoomDto room){
        return  new RoomEntities(
                base64Util.decode(room.getImage()),
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

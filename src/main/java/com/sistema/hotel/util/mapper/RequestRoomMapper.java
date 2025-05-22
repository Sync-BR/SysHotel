package com.sistema.hotel.util.mapper;

import com.sistema.hotel.model.room.dto.RequestRoomDto;
import com.sistema.hotel.model.room.dto.RoomDto;
import com.sistema.hotel.model.room.entities.RequestRoomEntities;
import org.springframework.stereotype.Component;

@Component
public class RequestRoomMapper {
    private final UserMapper userMapper;
    private final RoomMapper roomMapper;

    public RequestRoomMapper(UserMapper userMapper, RoomMapper roomMapper) {
        this.userMapper = userMapper;
        this.roomMapper = roomMapper;
    }

    public RequestRoomDto convertToDto(RoomDto dto) {
        return new RequestRoomDto(
                dto.getClient(),
                dto
        );
    }

    public RequestRoomEntities convertToEntity(RoomDto dto) {
        return new RequestRoomEntities(
                userMapper.dtoToEntity(dto.getClient()),
                roomMapper.covertEntitiesRoom(dto)
        );
    }
}

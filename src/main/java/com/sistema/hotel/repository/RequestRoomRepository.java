package com.sistema.hotel.repository;

import com.sistema.hotel.model.room.entities.RequestRoomEntities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRoomRepository extends JpaRepository<RequestRoomEntities, Long> {
    RequestRoomEntities findByClient_Cpf(String clientCpf);
    RequestRoomEntities findByRoom_NumberRoomAndRoom_NumberLetterAndRoom_RoomLevel(int roomNumberRoom, char roomNumberLetter, int roomRoomLevel);
}

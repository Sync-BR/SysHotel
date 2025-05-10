package com.sistema.hotel.repository;

import com.sistema.hotel.model.room.entities.RoomEntities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntities, Integer> {
    List<RoomEntities> findRoomEntitiesByNumberRoom(int numberRoom);

    List<RoomEntities> findRoomEntitiesByNumberLetter(char numberLetter);

    RoomEntities findRoomEntitiesByNumberRoomAndNumberLetter(int numberRoom, char numberLetter);
}

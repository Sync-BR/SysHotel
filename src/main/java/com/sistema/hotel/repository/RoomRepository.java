package com.sistema.hotel.repository;

import com.sistema.hotel.model.room.entities.RoomEntities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntities, Integer> {
    List<RoomEntities> findAllByAvailable(boolean available);
    List<RoomEntities> findRoomEntitiesByNumberRoom(int numberRoom);
    List<RoomEntities> findAllByRoomLevel(int roomLevel);
    RoomEntities findRoomEntitiesByNumberRoomAndNumberLetter(int numberRoom, char numberLetter);
    RoomEntities findRoomEntitiesByNumberRoomAndNumberLetterAndRoomLevel(int numberRoom, char numberLetter, int roomLevel);

}

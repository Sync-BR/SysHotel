package com.sistema.hotel.model.room.entities;

import com.sistema.hotel.model.client.entities.ClientEntities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity(name = "ROOM_REQUEST")
@Getter
@Setter
@ToString
public class RequestRoomEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate startDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntities client;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private RoomEntities room;

    public RequestRoomEntities() {
        this.startDate = LocalDate.now();
    }

    public RequestRoomEntities(ClientEntities client, RoomEntities room) {
        this.startDate = LocalDate.now();
        this.client = client;
        this.room = room;
    }
}

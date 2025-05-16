package com.sistema.hotel.model.room.entities;

import com.sistema.hotel.model.room.enumeration.TypeRoom;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ROOM")
public class RoomEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private byte[] Image;

    private int numberRoom;
    private int roomLevel;

    private char numberLetter;

    private Integer capacity;

    private Double price;

    private boolean available;
    private boolean smoker;
    private boolean accessibility;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TypeRoom type;



    public RoomEntities() {
    }


    public RoomEntities(byte[] image, int numberRoom, int roomLevel, char numberLetter, Integer capacity, Double price, boolean available, boolean smoker, boolean accessibility, String title, String description, TypeRoom type) {
        Image = image;
        this.numberRoom = numberRoom;
        this.roomLevel = roomLevel;
        this.numberLetter = numberLetter;
        this.capacity = capacity;
        this.price = price;
        this.available = available;
        this.smoker = smoker;
        this.accessibility = accessibility;
        this.title = title;
        this.description = description;
        this.type = type;
    }
}

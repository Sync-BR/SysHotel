package com.sistema.hotel.model.room.type;

import lombok.Getter;
@Getter
public enum TypeRoom {
    Single("Solteiro"),
    Couple("Casal"),
    Suite("Suíte Luxo"),;

    private final String type;
    private final int value;
    TypeRoom(String type) {
        this.type = type;
        value = ordinal();
    }


}

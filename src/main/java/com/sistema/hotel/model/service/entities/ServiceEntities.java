package com.sistema.hotel.model.service.entities;

import com.sistema.hotel.model.service.enumeration.ServicesCategoryEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class ServiceEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
    private String name;
    private String description;
    private double price;
    private boolean isActive;
    private ServicesCategoryEnum category;

    public ServiceEntities() {
    }

    public ServiceEntities(byte[] image, String name, String description, double price, boolean isActive, ServicesCategoryEnum category) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isActive = isActive;
        this.category = category;
    }
}

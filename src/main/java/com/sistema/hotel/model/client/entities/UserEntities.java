package com.sistema.hotel.model.client.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "USER")
public class UserEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    @OneToOne(mappedBy = "dateUser")
    private ClientEntities client;

    public UserEntities() {
    }

    public UserEntities(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserEntities(String username, String password, ClientEntities client) {
        this.username = username;
        this.password = password;
        this.client = client;
    }
}

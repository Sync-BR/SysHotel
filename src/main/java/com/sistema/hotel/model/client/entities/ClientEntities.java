package com.sistema.hotel.model.client.entities;

import com.sistema.hotel.model.client.address.entities.AddressEntities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "CLIENT")
public class ClientEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntities address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dateUser_id", referencedColumnName = "id")
    private UserEntities dateUser;

    public ClientEntities() {
    }

    public ClientEntities(String name, String cpf, String email, String phone, AddressEntities address, UserEntities user) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dateUser = user;
    }
}

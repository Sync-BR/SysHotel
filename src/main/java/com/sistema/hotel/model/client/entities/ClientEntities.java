package com.sistema.hotel.model.client.entities;

import com.sistema.hotel.model.address.entities.AddressEntities;
import com.sistema.hotel.model.client.enumeration.PermissionEnumeration;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity(name = "client")
@ToString
public class ClientEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    private boolean isActive;
    @Enumerated(EnumType.STRING)
    private PermissionEnumeration permission;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntities address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dateUser_id", referencedColumnName = "id")
    private UserEntities dateUser;


    public ClientEntities() {
        this.permission = PermissionEnumeration.DEV;
    }



    public ClientEntities(String name, String cpf, String email, String phone, boolean isActive, AddressEntities address, UserEntities dateUser) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.isActive = isActive;
        this.address = address;
        this.dateUser = dateUser;
        this.permission = PermissionEnumeration.DEV;
    }
}

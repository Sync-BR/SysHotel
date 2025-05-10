package com.sistema.hotel.model.address.entities;

import com.sistema.hotel.model.client.entities.ClientEntities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ADDRESS")
public class AddressEntities {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String street;
    private String complement;
    private String neighborhood;
    private String locality;
    private String state;
    private String postalCode;
    @OneToOne(mappedBy = "address")
    private ClientEntities client;

    public AddressEntities() {
    }

    public AddressEntities(String street, String complement, String neighborhood, String locality, String state, String postalCode) {
        this.street = street;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.locality = locality;
        this.state = state;
        this.postalCode = postalCode;
    }
}

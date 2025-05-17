package com.sistema.hotel.model.service.entities;

import com.sistema.hotel.model.client.entities.ClientEntities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "SERVICE_REQUEST")
@Getter
@Setter
public class RequestServiceEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean isActive;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntities client;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private ServiceEntities service;

    public RequestServiceEntities() {
    }

    public RequestServiceEntities(boolean isActive, ClientEntities client, ServiceEntities service) {
        this.isActive = isActive;
        this.client = client;
        this.service = service;
    }
}

package com.sistema.hotel.service.abstractions;

import com.sistema.hotel.model.client.entities.ClientEntities;

public interface ClientServiceInterface {
    void saveClient(ClientEntities newClient);
    boolean disableClient(int idClient);
    ClientEntities updateClient(ClientEntities clientUpdate);
}

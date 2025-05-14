package com.sistema.hotel.service.abstractions;

import com.sistema.hotel.model.client.entities.ClientEntities;

public interface ClientServiceInterface {
    void saveClient(ClientEntities newClient);
    void disableClient(ClientEntities disableClient);
    ClientEntities updateClient(ClientEntities clientUpdate);
}

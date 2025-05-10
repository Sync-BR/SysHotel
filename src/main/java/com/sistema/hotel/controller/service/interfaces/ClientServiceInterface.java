package com.sistema.hotel.controller.service.interfaces;

import com.sistema.hotel.model.client.entities.ClientEntities;

public interface ClientServiceInterface {
    void saveClient(ClientEntities newClient);
    boolean disableClient(int idClient);
    ClientEntities updateClient(ClientEntities clientUpdate);
}

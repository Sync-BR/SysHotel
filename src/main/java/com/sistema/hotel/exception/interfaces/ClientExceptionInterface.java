package com.sistema.hotel.exception.interfaces;

import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.model.client.entities.UserEntities;

public interface ClientExceptionInterface {
    boolean checkDate(ClientEntities dateCheck) throws ClientException;

    void checkSaveClient(ClientEntities newClient) throws ClientException;


}

package com.sistema.hotel.exception.interfaces;

import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.model.client.entities.ClientEntities;

public interface ClientExceptionInterface {
    boolean checkDate(ClientEntities dateCheck) throws ClientException;

    void checkSaveClient(ClientEntities newClient) throws ClientException;

    void checkUpdateClient(ClientEntities updateClient) throws ClientException;

    ClientEntities checkClientCpf(ClientEntities clientCpf) throws ClientException;
    ClientEntities checkFindDate(ClientEntities searchDate) throws ClientException;

}

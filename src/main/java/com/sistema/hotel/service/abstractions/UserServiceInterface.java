package com.sistema.hotel.service.abstractions;

import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.model.client.entities.UserEntities;

public interface UserServiceInterface {

    ClientEntities authenticateUser(UserEntities user) throws ClientException;

    UserEntities findByUser(String userSearch) throws ClientException;
}
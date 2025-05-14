package com.sistema.hotel.util.abstractions;

import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.model.client.dto.UserDto;
import com.sistema.hotel.model.client.entities.UserEntities;

public interface AuthenticateAbstractions {

    void authenticateUser(UserEntities user, UserDto dto) throws ClientException;
    void userExists(UserEntities userFount) throws ClientException;

    void checkIsLoggedIn(UserEntities user, String password) throws ClientException;


}

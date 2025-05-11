package com.sistema.hotel.util.validate;

import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.model.client.dto.UserDto;
import com.sistema.hotel.model.client.entities.UserEntities;
import com.sistema.hotel.util.abstractions.Authenticate;
import com.sistema.hotel.util.abstractions.PasswordEncrypt;
import org.springframework.stereotype.Component;

@Component
public class ValidateUserService implements Authenticate {
    private final PasswordEncrypt passwordEncrypt;

    public ValidateUserService(PasswordEncrypt passwordEncrypt) {
        this.passwordEncrypt = passwordEncrypt;
    }


    @Override
    public void authenticateUser(UserEntities user, UserDto dto) throws ClientException {
        if(!passwordEncrypt.checkPassword(dto.getPassword(), user.getPassword())) {
            throw new ClientException("Senha incorreta.");
        }
    }

    @Override
    public void userExists(UserEntities userFount) throws ClientException {
        if(userFount == null){
            throw new ClientException("Nenhum usuário correspondente foi encontrado.");
        }
    }


}

package com.sistema.hotel.util.validate;

import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.model.client.dto.UserDto;
import com.sistema.hotel.model.client.entities.UserEntities;
import com.sistema.hotel.repository.UserRepository;
import com.sistema.hotel.util.abstractions.AuthenticateAbstractions;
import com.sistema.hotel.util.abstractions.PasswordEncryptAbstractions;
import org.springframework.stereotype.Component;

@Component
public class ValidateUserService implements AuthenticateAbstractions {
    private final PasswordEncryptAbstractions passwordEncrypt;
    private final UserRepository userRepository;

    public ValidateUserService(PasswordEncryptAbstractions passwordEncrypt, UserRepository userRepository) {
        this.passwordEncrypt = passwordEncrypt;
        this.userRepository = userRepository;
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

    @Override
    public void checkIsLoggedIn(UserEntities user, String password) throws ClientException {
        UserEntities searchUser = userRepository.findByUsername(user.getUsername());
        if(searchUser == null){
            throw new ClientException("Usuário não encontrado");
        }
        if(!passwordEncrypt.checkPassword(password, searchUser.getPassword())){
            throw new ClientException("Dados invalidos.");
        }
    }


}

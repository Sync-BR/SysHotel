package com.sistema.hotel.service;

import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.model.client.entities.UserEntities;
import com.sistema.hotel.repository.UserRepository;
import com.sistema.hotel.service.abstractions.UserServiceInterface;
import com.sistema.hotel.util.validate.ValidateUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;
    private final ValidateUserService validatorUser;

    public UserService(UserRepository userRepository, ValidateUserService validatorUser) {
        this.userRepository = userRepository;
        this.validatorUser = validatorUser;
    }


    @Override
    public ClientEntities authenticateUser(UserEntities user) throws ClientException {
        return findByUser(user.getUsername()).getClient();
    }

    @Override
    public UserEntities findByUser(String userSearch) throws ClientException {
        UserEntities user = userRepository.findByUsername(userSearch);
        validatorUser.userExists(user);
        return user;
    }
}

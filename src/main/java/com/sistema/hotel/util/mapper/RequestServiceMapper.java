package com.sistema.hotel.util.mapper;

import com.sistema.hotel.model.service.dto.RequestServiceDto;
import com.sistema.hotel.model.service.entities.RequestServiceEntities;
import com.sistema.hotel.model.service.entities.ServiceEntities;
import com.sistema.hotel.util.PasswordUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RequestServiceMapper {
    private final ServiceMapper serviceMapper;
    private final UserMapper userMapper;

    public RequestServiceMapper() {
        this.serviceMapper = new ServiceMapper();
        this.userMapper = new UserMapper(new PasswordUtil(new BCryptPasswordEncoder()));
    }


    public RequestServiceEntities convertToEntity(RequestServiceDto dto) {
        return new RequestServiceEntities(
                dto.isActive(),
                userMapper.dtoToEntity(dto.getClient()),
                serviceMapper.convertToEntity(dto.getServices())
        );
    }
}

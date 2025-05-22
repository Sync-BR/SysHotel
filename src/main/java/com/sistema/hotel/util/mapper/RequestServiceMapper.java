package com.sistema.hotel.util.mapper;

import com.sistema.hotel.model.service.dto.RequestServiceDto;
import com.sistema.hotel.model.service.dto.ServicesDto;
import com.sistema.hotel.model.service.entities.RequestServiceEntities;
import com.sistema.hotel.model.service.entities.ServiceEntities;
import com.sistema.hotel.util.Base64Util;
import com.sistema.hotel.util.PasswordUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RequestServiceMapper {
    private final ServiceMapper serviceMapper;
    private final UserMapper userMapper;

    public RequestServiceMapper() {
        this.serviceMapper = new ServiceMapper(new Base64Util());
        this.userMapper = new UserMapper(new PasswordUtil(new BCryptPasswordEncoder()));
    }

    public List<RequestServiceDto> convertListToDto(List<RequestServiceEntities> requestServiceEntities) {
        List<RequestServiceDto> requestServiceDtos = new ArrayList<>();
        for (RequestServiceEntities request : requestServiceEntities) {
            requestServiceDtos.add(convertToDto(request));
        }
        return requestServiceDtos;
    }

    public RequestServiceEntities convertToEntity(ServicesDto dto) {
        return new RequestServiceEntities(
                dto.getIsActive(),
                userMapper.dtoToEntity(dto.getClient()),
                serviceMapper.convertToEntity(dto)
        );
    }

    public RequestServiceDto convertToDto(RequestServiceEntities entity) {
        return new RequestServiceDto(
                userMapper.entityToDto(entity.getClient()),
                serviceMapper.convertToDto(entity.getService()),
                entity.isActive()
        );
    }
}

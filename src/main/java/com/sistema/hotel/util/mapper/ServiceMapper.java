package com.sistema.hotel.util.mapper;

import com.sistema.hotel.model.service.dto.ServicesDto;
import com.sistema.hotel.model.service.entities.ServiceEntities;
import com.sistema.hotel.util.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceMapper {
    private final Base64Util baseUtil;

    public ServiceMapper(Base64Util baseUtil) {
        this.baseUtil = baseUtil;
    }

    public ServicesDto convertToDto(ServiceEntities serviceEntities) {

        return new ServicesDto(
                baseUtil.encode(serviceEntities.getImage()),
                serviceEntities.getName(),
                serviceEntities.getDescription(),
                serviceEntities.getCategory(),
                serviceEntities.isActive(),
                serviceEntities.getPrice()
        );
    }

    public ServiceEntities convertToEntity(ServicesDto dto) {


        return new ServiceEntities(
                baseUtil.decode(dto.getServiceImage()),
                dto.getServiceName(),
                dto.getServiceDescription(),
                dto.getServicePrice(),
                dto.getIsActive(),
                dto.getServiceCategory()
        );
    }

    public List<ServicesDto> convertToDto(List<ServiceEntities> service) {
        List<ServicesDto> responseService = new ArrayList<>();

        for (ServiceEntities serviceEntity : service) {
            responseService.add(new ServicesDto(
                    baseUtil.encode(serviceEntity.getImage()),
                    serviceEntity.getName(),
                    serviceEntity.getDescription(),
                    serviceEntity.getCategory(),
                    serviceEntity.isActive(),
                    serviceEntity.getPrice()
            ));
        }
        return responseService;
    }
}

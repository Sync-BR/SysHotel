package com.sistema.hotel.util.mapper;

import com.sistema.hotel.model.service.dto.ServicesDto;
import com.sistema.hotel.model.service.entities.ServiceEntities;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Base64;

@Component
public class ServiceMapper {


    public ServicesDto convertToDto(ServiceEntities serviceEntities) {
        String imgBase64 = null;
        if (serviceEntities.getImage() != null) {
            imgBase64 = Base64.getEncoder().encodeToString(serviceEntities.getImage());
        }
        return new ServicesDto(
                imgBase64,
                serviceEntities.getName(),
                serviceEntities.getDescription(),
                serviceEntities.getCategory(),
                serviceEntities.isActive(),
                serviceEntities.getPrice()
        );
    }

    public ServiceEntities convertToEntity(ServicesDto dto) {
        byte[] imageBytes = new byte[0];
        if (dto.getServiceImage() != null && !dto.getServiceImage().isEmpty()) {
            imageBytes = Base64.getDecoder().decode(dto.getServiceImage());
        }

        return new ServiceEntities(
                imageBytes,
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
            String base64Image = "";
            byte[] imageBytes = serviceEntity.getImage();

            if (serviceEntity.getImage() != null && serviceEntity.getImage().length > 0) {
                base64Image = Base64.getEncoder().encodeToString(imageBytes);
            }

            responseService.add(new ServicesDto(
                    base64Image,
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

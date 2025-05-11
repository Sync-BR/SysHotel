package com.sistema.hotel.util.mapper;

import com.sistema.hotel.model.address.dto.AddressDto;
import com.sistema.hotel.model.address.entities.AddressEntities;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    protected AddressEntities addressDtoToEntity(AddressDto dto) {
        return new AddressEntities(
                dto.getClientStreet(),
                dto.getClientComplement(),
                dto.getClientNeighborhood(),
                dto.getClientLocality(),
                dto.getClientState(),
                dto.getClientPostalCode()
        );
    }

    protected AddressDto addressEntityToDto(AddressEntities entity) {
        return new AddressDto(
                entity.getStreet(),
                entity.getComplement(),
                entity.getNeighborhood(),
                entity.getLocality(),
                entity.getState(),
                entity.getPostalCode()
        );
    }
}

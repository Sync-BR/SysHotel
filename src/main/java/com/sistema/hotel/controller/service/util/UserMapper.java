package com.sistema.hotel.controller.service.util;


import com.sistema.hotel.model.client.dto.ClientDto;
import com.sistema.hotel.model.client.dto.UserDto;
import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.model.client.entities.UserEntities;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AddressMapper {

    public ClientEntities dtoToEntity(ClientDto dto) {
        return new ClientEntities(
                dto.getClientName().trim(),
                formatCpf(dto.getClientCpf()),
                dto.getClientEmail().trim(),
                formatPhone(dto.getClientPhone()),
                addressDtoToEntity(dto.getAddress()),
                userDtoToEntity(dto.getClientUser())
        );
    }

    public ClientDto entityToDto(ClientEntities entity) {
        return new ClientDto(
                entity.getName(),
                formatCpf(entity.getCpf()),
                entity.getEmail(),
                formatPhone(entity.getPhone()),
                addressEntityToDto(entity.getAddress()),
                userEntityToDto(entity.getDateUser())
        );
    }

    public UserEntities userDtoToEntity(UserDto dto) {
        return new UserEntities(dto.getUsername().trim(), dto.getPassword().trim());
    }

    public UserDto userEntityToDto(UserEntities entity) {
        return new UserDto(entity.getUsername(), entity.getPassword());
    }

    private String formatCpf(String cpf) {
        return cpf.replaceAll("\\D", "").replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    private String formatPhone(String phone) {
        phone = phone.replaceAll("\\D", "");
        if (phone.matches("\\d{11}"))
            return phone.replaceFirst("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
        else if (phone.matches("\\d{10}"))
            return phone.replaceFirst("(\\d{2})(\\d{4})(\\d{4})", "($1) $2-$3");
        return phone;
    }


}

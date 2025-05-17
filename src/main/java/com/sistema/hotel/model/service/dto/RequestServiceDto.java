package com.sistema.hotel.model.service.dto;

import com.sistema.hotel.model.client.dto.ClientDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RequestServiceDto {
    @NotNull(message = "O Status da solicitação não pode ser nullo")
    private boolean active;
    @Valid
    @NotNull(message = "O Cliente não pode ser nullo")
    private ClientDto client;
    @Valid
    @NotNull(message = "O Serviço não pode ser nullo")
    private ServicesDto services;


    public RequestServiceDto(ClientDto client, ServicesDto services, boolean active) {
        this.client = client;
        this.services = services;
        this.active = active;
    }
}

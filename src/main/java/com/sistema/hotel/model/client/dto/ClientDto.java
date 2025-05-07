package com.sistema.hotel.model.client.dto;

import com.sistema.hotel.model.client.address.dto.AddressDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientDto {
    @NotBlank(message = "O nome do cliente é obrigatório.")
    @Size(min = 8, message = "Insira o nome completo do cliente (mínimo 8 caracteres).")
    private String clientName;

    @NotBlank(message = "O CPF do cliente é obrigatório.")
    @Size(min = 11, max = 11, message = "CPF inválido. Deve conter exatamente 11 dígitos.")
    private String clientCpf;

    @NotBlank(message = "O e-mail do cliente é obrigatório.")
    @Size(min = 10, max = 30, message = "Email inválido. Deve conter no minimo 10 digitos.")
    private String clientEmail;

    @NotBlank(message = "O número de telefone do cliente é obrigatório.")
    @Size(min = 11, max = 11, message = "Número de telefone inválido. Deve conter exatamente 11 dígitos.")
    private String clientPhone;

    @Valid
    private AddressDto address;
    @Valid
    private UserDto clientUser;


    public ClientDto() {
    }


}

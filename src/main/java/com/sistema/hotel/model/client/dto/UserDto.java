package com.sistema.hotel.model.client.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
    @NotBlank(message = "O nome de usuário é obrigatório.")
    @Size(min = 5, max = 10, message = "Usuário deve ter no mínimo 5 caracteres e no máximo 10.")
    private String username;
    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
    private String password;
    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
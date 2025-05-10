package com.sistema.hotel.model.address.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressDto {
    @NotBlank(message = "O nome da rua é obrigatório.")
    private String clientStreet;

    @NotBlank(message = "O complemento do endereço é obrigatório.")
    private String clientComplement;

    @NotBlank(message = "O bairro é obrigatório.")
    private String clientNeighborhood;

    @NotBlank(message = "A cidade é obrigatória.")
    private String clientLocality;

    @NotBlank(message = "O estado é obrigatório.")
    private String clientState;

    @Pattern(regexp = "\\d{8}", message = "O CEP deve conter exatamente 8 dígitos numéricos.")
    @NotBlank(message = "O CEP é obrigatório.")
    private String clientPostalCode;


    public AddressDto(String clientStreet, String clientComplement, String clientNeighborhood, String clientLocality, String clientState, String clientPostalCode) {
        this.clientStreet = clientStreet;
        this.clientComplement = clientComplement;
        this.clientNeighborhood = clientNeighborhood;
        this.clientLocality = clientLocality;
        this.clientState = clientState;
        this.clientPostalCode = clientPostalCode;
    }
}

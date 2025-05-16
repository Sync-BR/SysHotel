package com.sistema.hotel.model.service.dto;

import com.sistema.hotel.model.client.dto.ClientDto;
import com.sistema.hotel.model.service.enumeration.ServicesCategoryEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServicesDto {

    @NotBlank(message = "A imagem do serviço é obrigatória.")
    @Size(min = 10, message = "A URL da imagem deve conter no mínimo 10 caracteres.")
    private String serviceImage;

    @NotBlank(message = "O nome do serviço é obrigatório.")
    @Size(min = 4, message = "O nome do serviço deve conter no mínimo 4 caracteres.")
    private String serviceName;

    @NotBlank(message = "A descrição do serviço é obrigatória.")
    @Size(min = 10, message = "A descrição do serviço deve conter no mínimo 10 caracteres.")
    private String serviceDescription;

    @NotNull(message = "A categoria do serviço é obrigatória.")
    @Valid
    private ServicesCategoryEnum serviceCategory;

    @NotNull(message = "O status do serviço é obrigatório.")
    private Boolean isActive;

    @NotNull(message = "O preço do serviço é obrigatório.")
    @Positive(message = "O preço do serviço deve ser maior que zero.")
    private Double servicePrice;
    @Valid
    @NotNull(message = "Campo de cliente é obrigatório")
    private ClientDto client;

    public ServicesDto(String serviceImage, String serviceName, String serviceDescription, ServicesCategoryEnum serviceCategory, Boolean isActive, Double servicePrice) {
        this.serviceImage = serviceImage;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.serviceCategory = serviceCategory;
        this.isActive = isActive;
        this.servicePrice = servicePrice;
    }


}

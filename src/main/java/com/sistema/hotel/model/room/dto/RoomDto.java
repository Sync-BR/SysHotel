package com.sistema.hotel.model.room.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomDto {

    @Min(value = 1, message = "O número do quarto deve ser maior que 0")
    private int number;

    @Min(value = 0, message = "O andar do quarto deve ser maior ou igual a 0")
    private int level;


    @NotNull(message = "A capacidade é obrigatória")
    @Positive(message = "A capacidade deve ser maior que 0")
    private Integer capacity;

    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço deve ser maior que 0")
    private Double price;

    private boolean available;
    private boolean smoker;
    private boolean accessibility;

    @NotBlank(message = "A imagem é obrigatória")
    private String image;
    @NotBlank(message = "O título é obrigatório")
    private String title;

    @NotBlank(message = "A descrição é obrigatória")
    private String description;
    @NotNull(message = "A letra do número do quarto é obrigatória")
    @Size(max = 1, message = "A letra do quarto deve conter no máximo 1 caractere")
    private String letter;
    @NotBlank(message = "O tipo é obrigatório")
    private String typeRoom;

    public RoomDto(int number, int level, Integer capacity, Double price, boolean available, boolean smoker, boolean accessibility, String image, String title, String description, String letter, String typeRoom) {
        this.number = number;
        this.level = level;
        this.capacity = capacity;
        this.price = price;
        this.available = available;
        this.smoker = smoker;
        this.accessibility = accessibility;
        this.image = image;
        this.title = title;
        this.description = description;
        this.letter = letter;
        this.typeRoom = typeRoom;
    }
}

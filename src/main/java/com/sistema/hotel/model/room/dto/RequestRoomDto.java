package com.sistema.hotel.model.room.dto;

import com.sistema.hotel.model.client.dto.ClientDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RequestRoomDto {
    @Valid
    @NotNull(message = "Campo de cliente é obrigatório")
    private ClientDto client;
    @Valid
    @NotNull(message = "Campo detalhado do quarto é obrigatório")
    private RoomDto room;

    public RequestRoomDto() {
    }

    public RequestRoomDto(ClientDto client, RoomDto room) {
        this.client = client;
        this.room = room;
    }
}

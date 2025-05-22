package com.sistema.hotel.util.validate;

import com.sistema.hotel.exception.RoomException;
import com.sistema.hotel.exception.interfaces.RequestRoomException;
import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.model.room.entities.RequestRoomEntities;
import com.sistema.hotel.repository.ClientRepository;
import com.sistema.hotel.repository.RequestRoomRepository;
import com.sistema.hotel.repository.RoomRepository;
import com.sistema.hotel.service.ClientService;
import org.springframework.stereotype.Component;

@Component
public class ValidateRequestRoom implements RequestRoomException {
    private final RoomRepository roomRepository;
    private final RequestRoomRepository repository;
    private final ClientService clientService;

    public ValidateRequestRoom(RoomRepository roomRepository, RequestRoomRepository requestRoomRepository, ClientService clientService) {
        this.roomRepository = roomRepository;
        this.repository = requestRoomRepository;
        this.clientService = clientService;
    }
    @Override
    public void checkAvailability(RequestRoomEntities requestEntity)  throws RoomException {
        if(repository.findByRoom_NumberRoomAndRoom_NumberLetterAndRoom_RoomLevel(requestEntity.getRoom().getNumberRoom(), requestEntity.getRoom().getNumberLetter(), requestEntity.getRoom().getRoomLevel()) != null){
            throw new RoomException("Este quarto já possuir um proprietario!");
        };

    }

    @Override
    public ClientEntities checkRentalLimit(ClientEntities client) throws RoomException{
        if(repository.findByClient_Cpf(client.getCpf()) != null){
            throw new RoomException("O Cliente já possuir um quarto alugado");
        }
        return clientService.findDate(client);
    }

    @Override
    public void checkSaved(RequestRoomEntities requestRoom) throws RoomException {
        if(requestRoom == null){
            throw new RoomException("Não foi adicionar cliente nesse quarto!");
        }
    }
}

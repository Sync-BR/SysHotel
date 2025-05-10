package com.sistema.hotel.controller.service.util;

import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.exception.RoomException;
import com.sistema.hotel.exception.interfaces.ClientExceptionInterface;
import com.sistema.hotel.exception.interfaces.RoomExceptionInterface;
import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.model.room.entities.RoomEntities;
import com.sistema.hotel.repository.ClientRepository;
import com.sistema.hotel.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService implements ClientExceptionInterface, RoomExceptionInterface {
    private final ClientRepository repository;
    protected final RoomRepository roomRepository;

    public ValidatorService(ClientRepository repository, RoomRepository roomRepository) {
        this.repository = repository;
        this.roomRepository = roomRepository;
    }

    @Override
    public boolean checkDate(ClientEntities dateCheck) throws ClientException {
        if (repository.findClientEntitiesByCpf(dateCheck.getCpf()) != null)
            throw new ClientException("O CPF informado já está cadastrado.");

        if (repository.findClientEntitiesByEmail(dateCheck.getEmail()) != null)
            throw new ClientException("O e-mail informado já está em uso.");

        if (repository.findClientEntitiesByDateUser_Username(dateCheck.getDateUser().getUsername()) != null)
            throw new ClientException("O nome de usuário escolhido já está em uso.");

        return true;
    }

    @Override
    public void checkSaveClient(ClientEntities newClient) throws ClientException {
        if (newClient == null) {
            throw new ClientException("Ocorreu um erro ao tentar salvar o cliente. Verifique os dados e tente novamente.");
        }
    }

    @Override
    public void checkRoomSaved(RoomEntities room) throws RoomException {
        if (room.getId() == 0) {
            throw new RoomException("Erro ao tentar adicionar um quarto. Verifique os dados e tente novamente.");
        }
    }

    @Override
    public void checkRoomAvailability(RoomEntities room) throws RoomException {
        if (room != null) {
            throw new RoomException("Já existe uma sala com essas informações. Verifique os dados e tente novamente.");
        }
    }

    @Override
    public boolean checkAvailability(int numberRoom, char letterRoom) {
        if (roomRepository.findRoomEntitiesByNumberRoom(numberRoom) != null) {
            checkRoomAvailability(roomRepository.findRoomEntitiesByNumberRoomAndNumberLetter(numberRoom, letterRoom));
        }
        return true;
    }
}

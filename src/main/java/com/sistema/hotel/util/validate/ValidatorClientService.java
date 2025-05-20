package com.sistema.hotel.util.validate;

import com.sistema.hotel.exception.ClientException;
import com.sistema.hotel.exception.interfaces.ClientExceptionInterface;

import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.repository.ClientRepository;

import org.springframework.stereotype.Component;

@Component
public class ValidatorClientService implements ClientExceptionInterface {
    private final ClientRepository repository;

    public ValidatorClientService(ClientRepository repository) {
        this.repository = repository;
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
    public void checkUpdateClient(ClientEntities updateClient) throws ClientException {
        if (updateClient == null) {
            throw new ClientException("Erro ao atualizar os dados do cliente. Tente novamente mais tarde.");
        }
    }

    @Override
    public ClientEntities checkClientCpf(ClientEntities clientCpf) throws ClientException {
        if (repository.findClientEntitiesByCpf(clientCpf.getCpf()) == null) {
            throw new ClientException("O CPF não encontrado.");
        }
        return repository.findClientEntitiesByCpf(clientCpf.getCpf());
    }


    @Override
    public ClientEntities checkFindDate(ClientEntities searchDate) throws ClientException {
        if (searchDate.getId() == 0) {
            throw new ClientException("Cliente não encontrado. Verifique o CPF ou ID informado.");
        }
        return searchDate;
    }


}

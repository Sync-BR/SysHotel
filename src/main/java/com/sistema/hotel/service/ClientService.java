package com.sistema.hotel.service;


import com.sistema.hotel.model.address.entities.AddressEntities;
import com.sistema.hotel.model.client.entities.UserEntities;
import com.sistema.hotel.service.abstractions.ClientServiceInterface;
import com.sistema.hotel.util.validate.ValidatorClientService;
import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.repository.ClientRepository;

import org.springframework.stereotype.Service;

@Service
public class ClientService implements ClientServiceInterface {
    private final ValidatorClientService validate;
    private final ClientRepository clientRepository;

    public ClientService(ValidatorClientService validate, ClientRepository clientRepository) {
        this.validate = validate;
        this.clientRepository = clientRepository;
    }


    public ClientEntities findDate(ClientEntities searchDate) {
        return validate.checkFindDate(clientRepository.findClientEntitiesByCpf(searchDate.getCpf()));
    }

    public ClientEntities applyExistingIds(ClientEntities clientUpdate) {
        AddressEntities addressDateSaved = clientUpdate.getAddress();
        addressDateSaved.setId(findDate(clientUpdate).getId());

        UserEntities userEntities = clientUpdate.getDateUser();
        userEntities.setId(findDate(clientUpdate).getId());

        clientUpdate.setId(findDate(clientUpdate).getId());
        clientUpdate.setAddress(addressDateSaved);
        clientUpdate.setDateUser(userEntities);

        return clientUpdate;
    }


    @Override
    public void saveClient(ClientEntities newClient) {
        if (validate.checkDate(newClient)) {
            validate.checkSaveClient(clientRepository.save(newClient));
        }
    }

    @Override
    public void disableClient(ClientEntities disableClient) {
        ClientEntities searchDate = findDate(disableClient);
        if (searchDate != null) {
            searchDate.setActive(false);
            clientRepository.save(searchDate);
        }
    }


    @Override
    public ClientEntities updateClient(ClientEntities clientUpdate) {
        clientUpdate = applyExistingIds(clientUpdate);
        if (clientUpdate.getId() != 0 || clientUpdate.getAddress().getId() != 0) {
            validate.checkUpdateClient(clientRepository.save(clientUpdate));
        }
        return clientUpdate;
    }
}

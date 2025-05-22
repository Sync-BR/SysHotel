package com.sistema.hotel.util.validate;

import com.sistema.hotel.exception.ServicesException;
import com.sistema.hotel.exception.interfaces.RequestServicesExceptionInterface;
import com.sistema.hotel.exception.interfaces.ServicesExceptionInterface;
import com.sistema.hotel.model.service.entities.RequestServiceEntities;
import com.sistema.hotel.model.service.entities.ServiceEntities;
import com.sistema.hotel.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidateServices implements ServicesExceptionInterface, RequestServicesExceptionInterface {
    @Autowired
    private ServicesRepository repository;


    @Override
    public void checkDateSaved(ServiceEntities entity) throws ServicesException {
        if (entity == null) {
            throw new ServicesException("ServiceEntities is null");
        }
    }

    @Override
    public ServiceEntities checkServiceExists(ServiceEntities entity) throws ServicesException {
        if (repository.findByName(entity.getName()) == null || repository.findByName(entity.getName()).isEmpty()) {
            throw new ServicesException("Serviço não encontrado");
        }
        if(!repository.findByName(entity.getName()).get(0).isActive()){
            throw new ServicesException("Serviço não disponivel");
        }
        return repository.findByName(entity.getName()).getFirst();

    }


    @Override
    public void checkSave(RequestServiceEntities entities) throws ServicesException {
        if (entities == null || entities.getClient() == null || entities.getService() == null) {
            throw new ServicesException("Falhar ao salvar o servico");
        }
    }
}

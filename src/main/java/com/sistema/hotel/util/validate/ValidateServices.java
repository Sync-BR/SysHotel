package com.sistema.hotel.util.validate;

import com.sistema.hotel.exception.ServicesException;
import com.sistema.hotel.exception.interfaces.RequestServicesExceptionInterface;
import com.sistema.hotel.exception.interfaces.ServicesExceptionInterface;
import com.sistema.hotel.model.service.entities.RequestServiceEntities;
import com.sistema.hotel.model.service.entities.ServiceEntities;
import org.springframework.stereotype.Component;

@Component
public class ValidateServices implements ServicesExceptionInterface, RequestServicesExceptionInterface {


    @Override
    public void checkDateSaved(ServiceEntities entity) throws ServicesException {
        if(entity == null){
            throw new ServicesException("ServiceEntities is null");
        }
    }



    @Override
    public void checkSave(RequestServiceEntities entities) throws ServicesException {
        if(entities == null || entities.getClient() == null || entities.getService() == null){
            throw new ServicesException("Falhar ao salvar o servico");
        }
    }
}

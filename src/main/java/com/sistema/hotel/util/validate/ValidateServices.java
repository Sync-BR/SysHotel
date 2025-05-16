package com.sistema.hotel.util.validate;

import com.sistema.hotel.exception.ServicesException;
import com.sistema.hotel.exception.interfaces.ServicesExceptionInterface;
import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.model.service.entities.ServiceEntities;
import org.springframework.stereotype.Component;

@Component
public class ValidateServices implements ServicesExceptionInterface {


    @Override
    public void checkDateSaved(ServiceEntities entity) throws ServicesException {
        if(entity == null){
            throw new ServicesException("ServiceEntities is null");
        }
    }
}

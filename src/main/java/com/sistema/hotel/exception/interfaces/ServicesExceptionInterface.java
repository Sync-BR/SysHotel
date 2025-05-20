package com.sistema.hotel.exception.interfaces;

import com.sistema.hotel.exception.ServicesException;
import com.sistema.hotel.model.service.entities.ServiceEntities;

public interface ServicesExceptionInterface {
    void checkDateSaved(ServiceEntities entity) throws ServicesException;
    ServiceEntities checkServiceExists(ServiceEntities entity) throws ServicesException;

}

package com.sistema.hotel.exception.interfaces;

import com.sistema.hotel.exception.ServicesException;
import com.sistema.hotel.model.service.entities.RequestServiceEntities;

public interface RequestServicesExceptionInterface {
    void checkSave(RequestServiceEntities dto) throws ServicesException;
}

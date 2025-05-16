package com.sistema.hotel.service.abstractions;

import com.sistema.hotel.model.service.entities.ServiceEntities;

public interface ServiceHotelInterface {
    void save(ServiceEntities service);
    void update(ServiceEntities service);
    void disable(ServiceEntities service);
}

package com.sistema.hotel.service.abstractions;

import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.model.service.entities.RequestServiceEntities;

import java.util.List;

public interface ServiceRequestInterface {
    void save(RequestServiceEntities entities);
    List<RequestServiceEntities> responseListServicesRequest(ClientEntities client);

}

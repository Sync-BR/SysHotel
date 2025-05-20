package com.sistema.hotel.util;

import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.model.client.enumeration.PermissionEnumeration;
import org.springframework.stereotype.Component;

@Component
public class PermissionValidate {

    public boolean checkPermissionDev(ClientEntities client) {
        return client.getPermission().equals(PermissionEnumeration.DEV);
    }

}

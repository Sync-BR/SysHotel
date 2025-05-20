package com.sistema.hotel.repository;

import com.sistema.hotel.model.service.entities.RequestServiceEntities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestServiceRepository extends JpaRepository<RequestServiceEntities, Long> {
    List<RequestServiceEntities> findByIsActive(boolean isActive);
}

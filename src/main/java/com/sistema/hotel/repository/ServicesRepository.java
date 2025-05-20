package com.sistema.hotel.repository;

import com.sistema.hotel.model.service.entities.ServiceEntities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicesRepository extends JpaRepository<ServiceEntities, Integer> {
    List<ServiceEntities> findByName(String name);
}

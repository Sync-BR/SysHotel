package com.sistema.hotel.repository;

import com.sistema.hotel.model.client.entities.UserEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntities, Long> {

    UserEntities findByUsername(String username);
}

package com.sistema.hotel.repository;

import com.sistema.hotel.model.client.entities.ClientEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntities, Long> {
    ClientEntities findClientEntitiesByCpf(String cpf);

    ClientEntities findClientEntitiesByEmail(String email);

    ClientEntities findClientEntitiesByDateUser_Username(String dateUserUsername);
}

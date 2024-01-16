package com.coches.cochesArtiffact.persistance.repository;

import com.coches.cochesArtiffact.persistance.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerCrudRepository extends JpaRepository<CustomerEntity, String> {

    // Query method pilas
    Optional<CustomerEntity> findByEmail(String email);

}

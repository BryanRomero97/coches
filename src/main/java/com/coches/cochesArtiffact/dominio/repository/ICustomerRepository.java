package com.coches.cochesArtiffact.dominio.repository;

import com.coches.cochesArtiffact.dominio.dto.CustomerDto;
import com.coches.cochesArtiffact.dominio.dto.MarcaCocheDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {


    List<CustomerDto> getAll();


    Optional<CustomerDto> getCustomerByCardId(String cardId);

    Optional<CustomerDto> getCustomerByEmail(String email);


    CustomerDto save(CustomerDto newCustomer);


    void delete(String cardId);
}

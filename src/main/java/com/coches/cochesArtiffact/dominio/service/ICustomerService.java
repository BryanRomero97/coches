package com.coches.cochesArtiffact.dominio.service;

import com.coches.cochesArtiffact.dominio.dto.CustomerDto;
import com.coches.cochesArtiffact.dominio.dto.MarcaCocheDto;
import com.coches.cochesArtiffact.dominio.dto.ResponseCustomerDto;

import java.util.List;
import java.util.Optional;


public interface ICustomerService {


    List<CustomerDto> getAll();


    Optional<CustomerDto> getCustomerByCardId(String cardId);

    Optional<CustomerDto> getCustomerByEmail(String email);


    ResponseCustomerDto save(CustomerDto newCustomer);

    Optional<CustomerDto> update(CustomerDto modifyCustomer);

    boolean delete(String cardId);

}

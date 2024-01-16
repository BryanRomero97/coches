package com.coches.cochesArtiffact.persistance.repository;

import com.coches.cochesArtiffact.dominio.dto.CustomerDto;
import com.coches.cochesArtiffact.dominio.repository.ICustomerRepository;
import com.coches.cochesArtiffact.persistance.entity.CustomerEntity;
import com.coches.cochesArtiffact.persistance.mapper.ICustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CustomerRepository implements ICustomerRepository {


    private final ICustomerCrudRepository iCustomerCrudRepository;

    private final ICustomerMapper iCustomerMapper;

    @Override
    public List<CustomerDto> getAll() {

        return iCustomerMapper.toCustomersDto(iCustomerCrudRepository.findAll());


    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String cardId) {

        return iCustomerCrudRepository.findById(cardId)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {

        return iCustomerCrudRepository.findByEmail(email)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public CustomerDto save(CustomerDto newCustomer) {

        CustomerEntity customerEntity = iCustomerMapper.toCustomerEntity(newCustomer);

        return iCustomerMapper.toCustomerDto(iCustomerCrudRepository.save(customerEntity));
    }

    @Override
    public void delete(String cardId) {

        iCustomerCrudRepository.deleteById(cardId);

    }
}

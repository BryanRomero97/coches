package com.coches.cochesArtiffact.persistance.mapper;

import com.coches.cochesArtiffact.dominio.dto.CustomerDto;
import com.coches.cochesArtiffact.persistance.entity.CustomerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Interface Mapper, realiza la transaccion de datos entre el Dto y la Entidad
 */
@Mapper(componentModel = "spring")
public interface ICustomerMapper {

    CustomerDto toCustomerDto(CustomerEntity customerEntity);


    CustomerEntity toCustomerEntity(CustomerDto customerDto);

    List<CustomerDto> toCustomersDto(List<CustomerEntity> customerEntityList);


}

package com.coches.cochesArtiffact.persistance.mapper;

import com.coches.cochesArtiffact.dominio.dto.MarcaCocheDto;
import com.coches.cochesArtiffact.persistance.entity.MarcaCocheEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Esta clase nos pertime con la ayuda de Map Structure, crear una trancision de datos
 * entre El modelo de MarcaCoche y el Pojo de marcaCoche de esta manera no dependeremos de la bases de datos
 */
@Mapper(componentModel = "spring")
public interface IMarcaCocheMapper {

    /**
     * realizamos el mapeo de datos: mapeamos las variables  Entity y lo pasamos a Pojo(objeto plano)
     * source : Entidad origen, Target : Entidad destino
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    MarcaCocheDto toMarcaCocheDto(MarcaCocheEntity marcaEntity);

    /**
     * Convierte el pojo en una entity
     */
    @InheritInverseConfiguration
    MarcaCocheEntity toMarcaCocheEntity(MarcaCocheDto marcaPojo);

    /**
     * Retorna una lista de coches pojo transformada de una lista de entidades Entity
     * @param MarcasCocheEntity Entidad a transformar
     * @return Lista Pojo
     */
    List<MarcaCocheDto> toMarcasCocheDto(List<MarcaCocheEntity> MarcasCocheEntity);


}

package com.coches.cochesArtiffact.persistance.repository;

import com.coches.cochesArtiffact.dominio.dto.MarcaCocheDto;
import com.coches.cochesArtiffact.dominio.repository.IMarcaCocheRepository;
import com.coches.cochesArtiffact.persistance.entity.MarcaCocheEntity;
import com.coches.cochesArtiffact.persistance.mapper.IMarcaCocheMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Repositorio de MarcaCoche
 */
@RequiredArgsConstructor // genera constructor cuyos atributos sean variable "FINAL" o no Null
@Repository
public class MarcaCarroRepository implements IMarcaCocheRepository {

    /**
     * CRUD de marcacoche
     */
    private final IMarcaCocheCrudRepository iMarcaCocheCrudRepository;

    /**
     * Mapper de Marcacoche
     */

    private final IMarcaCocheMapper iMarcaCocheMapper;

    /**
     * Devuelve una lista con todas la Marcas de coche existentes
     *
     * @return lista de marcas
     */
    @Override
    public List<MarcaCocheDto> getAll() {
        return iMarcaCocheMapper.toMarcasCocheDto(iMarcaCocheCrudRepository.findAll());
    }

    @Override // evitar NullPointerExeption
    public Optional<MarcaCocheDto> getMarcaCoche(Integer id) {
        return iMarcaCocheCrudRepository.findById(id)
                .map(iMarcaCocheMapper::toMarcaCocheDto); // metodo por referencia

        // OR LAmbda return iMarcaCocheCrudRepository.findById(id).
        // map(marcaCocheEntity -> iMarcaCocheMapper.toMarcaCochePojo(marcaCocheEntity));
    }

    /**
     * recibe un pojo lo transforma en entidad para guardarlo
     * y despues retornar la entidad transfomandola nuevamente a pojo
     *
     * @param newMarcaCoche marca coche a guardar
     * @return pojo guardado
     */
    @Override
    public MarcaCocheDto save(MarcaCocheDto newMarcaCoche) {

        MarcaCocheEntity marcaCocheEntity = iMarcaCocheMapper.toMarcaCocheEntity(newMarcaCoche);

        return iMarcaCocheMapper.toMarcaCocheDto(iMarcaCocheCrudRepository.save(marcaCocheEntity));
    }

    /**
     * @param idMarcaCoche id de MarcaCoche a eliminar
     */
    @Override
    public void delete(Integer idMarcaCoche) {

        iMarcaCocheCrudRepository.deleteById(idMarcaCoche);
    }
}

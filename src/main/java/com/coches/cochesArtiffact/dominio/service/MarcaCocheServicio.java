package com.coches.cochesArtiffact.dominio.service;

import com.coches.cochesArtiffact.dominio.dto.MarcaCocheDto;
import com.coches.cochesArtiffact.dominio.repository.IMarcaCocheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de MArcaCoche
 */
@RequiredArgsConstructor
@Service
public class MarcaCocheServicio implements IMarcaCocheServicio {

    private final IMarcaCocheRepository iMarcaCocheRepository;

    /**
     * retorna la lista de marcas almacenadas
     * @return lista de marcas
     */
    @Override
    public List<MarcaCocheDto> getAll() {
        return iMarcaCocheRepository.getAll();
    }

    /**
     * Retorna una marca egun su id (consulta)
     * @param id
     * @return marca segun id
     */
    @Override
    public Optional<MarcaCocheDto> getMarcaCoche(Integer id) {
        return iMarcaCocheRepository.getMarcaCoche(id);
    }

    @Override
    public MarcaCocheDto save(MarcaCocheDto newMarcaCoche) {
        return iMarcaCocheRepository.save(newMarcaCoche);
    }

    @Override
    public MarcaCocheDto update(MarcaCocheDto newMarcaCoche) {
        if (iMarcaCocheRepository.getMarcaCoche(newMarcaCoche.getId()).isEmpty()){
            return null;
        }
        return iMarcaCocheRepository.save(newMarcaCoche);
    }

    /**
     * Elimina marca existente se agrega exepcion para evitar fallas
     * @param idMarcaCoche id de MarcaCoche a eliminar
     * @return booleano
     */
    @Override
    public boolean delete(Integer idMarcaCoche) {

        if (iMarcaCocheRepository.getMarcaCoche(idMarcaCoche).isEmpty()){
            return false;
        }


        iMarcaCocheRepository.delete(idMarcaCoche);
        return true;


    }


}

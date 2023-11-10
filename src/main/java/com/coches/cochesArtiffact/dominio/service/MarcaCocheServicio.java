package com.coches.cochesArtiffact.dominio.service;

import com.coches.cochesArtiffact.dominio.pojo.MarcaCochePojo;
import com.coches.cochesArtiffact.dominio.repository.IMarcaCocheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public List<MarcaCochePojo> getAll() {
        return iMarcaCocheRepository.getAll();
    }

    /**
     * Retorna una marca egun su id (consulta)
     * @param id
     * @return marca segun id
     */
    @Override
    public Optional<MarcaCochePojo> getMarcaCoche(Integer id) {
        return iMarcaCocheRepository.getMarcaCoche(id);
    }

    @Override
    public MarcaCochePojo save(MarcaCochePojo newMarcaCoche) {
        return iMarcaCocheRepository.save(newMarcaCoche);
    }

    @Override
    public MarcaCochePojo update(MarcaCochePojo newMarcaCoche) {
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

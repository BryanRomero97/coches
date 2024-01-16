package com.coches.cochesArtiffact.dominio.repository;

import com.coches.cochesArtiffact.dominio.dto.MarcaCocheDto;

import java.util.List;
import java.util.Optional;

public interface IMarcaCocheRepository {

    /**
     * Devuelve una lista con las marcas de coches
     *
     * @return lista de marcas de coches
     */
    List<MarcaCocheDto> getAll();

    /**
     * Devuelde una marca de coche dado su id
     * impide que se rompa el programa (nullPointerExeption) cuando intenta operar un objeto nulo
     *
     * @param id
     * @return Optional del marca coche encontrado
     */
    Optional<MarcaCocheDto> getMarcaCoche(Integer id);

    /**
     * Guarda una nueva marca coche
     *
     * @param newMarcaCoche marca coche a guardar
     * @return marca coche almacenada
     */
    MarcaCocheDto save(MarcaCocheDto newMarcaCoche);

    /**
     * Elimina una marca coche dado su ID
     *
     * @param idMarcaCoche id de MarcaCoche a eliminar
     */
    void delete(Integer idMarcaCoche);


}

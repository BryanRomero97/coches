package com.coches.cochesArtiffact.dominio.service;

import com.coches.cochesArtiffact.dominio.pojo.MarcaCochePojo;

import java.util.List;
import java.util.Optional;

public interface IMarcaCocheServicio {

    /**
     * Devuelve una lista con las marcas de coches
     * @return lista de marcas de coches
     */
    List<MarcaCochePojo> getAll();

    /** Devuelde una marca de coche dado su id
     * impide que se rompa el programa (nullPointerExeption) cuando intenta operar un objeto nulo
     *
     * @param id
     * @return Optional del marca coche encontrado
     */
    Optional<MarcaCochePojo> getMarcaCoche(Integer id);

    /**
     * Guarda una nueva marca coche
     * @param newMarcaCoche marca coche a guardar
     * @return marca coche almacenada
     */
    MarcaCochePojo save(MarcaCochePojo newMarcaCoche);

    /**
     * Actualiza una marca coche
     * @param newMarcaCoche marca a actualizar
     * @return marca coche actualizada
     */
    MarcaCochePojo update(MarcaCochePojo newMarcaCoche);

    /**
     * Elimina una marca coche dado su ID
     * @param idMarcaCoche id de MarcaCoche a eliminar
     */
    boolean delete(Integer idMarcaCoche);


}

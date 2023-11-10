package com.coches.cochesArtiffact.controller;

import com.coches.cochesArtiffact.dominio.pojo.MarcaCochePojo;
import com.coches.cochesArtiffact.dominio.service.IMarcaCocheServicio;
import com.coches.cochesArtiffact.dominio.service.MarcaCocheServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * controlador REST de marca coche
 */

@RestController
@RequestMapping(path = "/marcas-coches")
@RequiredArgsConstructor
public class MarcaCarroControlador {

    private final IMarcaCocheServicio iMarcaCocheServicio;

    /**
     * lista todas las marcas de coches registradas y devulve un codigo
     * HttpStatus.OK
     * @return estado
     */
    @GetMapping()
    public ResponseEntity<List<MarcaCochePojo>>  getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iMarcaCocheServicio.getAll());
    }

    /**
     * Busca una marca coche dado su id
     * @param id
     * @return estado 404 o retorna marca encontrada segun su id
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<MarcaCochePojo> getMarcaCoche( @PathVariable Integer id){
        return ResponseEntity.of(iMarcaCocheServicio.getMarcaCoche(id));
    }

    /**
     * Guarda una marca
     * @param marcaCochePojo marca cochea crear
     * @return Estado Ok
     */
    @PostMapping()
    public ResponseEntity<MarcaCochePojo> save(@RequestBody MarcaCochePojo marcaCochePojo){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iMarcaCocheServicio.save(marcaCochePojo));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build() ;
        }

    }

    /**
     * Actualiza una marca coche existente
     * @param macaCochePojo marca a actualizar
     * @return marca mactualizada
     */
    @PatchMapping
    public ResponseEntity<MarcaCochePojo> update(@RequestBody MarcaCochePojo macaCochePojo) {

        MarcaCochePojo marcaCochePojo = iMarcaCocheServicio.update(macaCochePojo);

        if (marcaCochePojo == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(macaCochePojo);
        }
    }

    /***
     * Elimina una marca coche existente de lo contrario arroja not found
     * @param id elemento eliminado
     * @return estado OK o estado $404
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){

        return new ResponseEntity<>(this.iMarcaCocheServicio.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);

    }







}

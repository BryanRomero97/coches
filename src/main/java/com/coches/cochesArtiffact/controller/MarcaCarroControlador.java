package com.coches.cochesArtiffact.controller;

import com.coches.cochesArtiffact.dominio.dto.MarcaCocheDto;
import com.coches.cochesArtiffact.dominio.service.IMarcaCocheServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<MarcaCocheDto>>  getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iMarcaCocheServicio.getAll());
    }

    /**
     * Busca una marca coche dado su id
     * @param id
     * @return estado 404 o retorna marca encontrada segun su id
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<MarcaCocheDto> getMarcaCoche(@PathVariable Integer id){
        return ResponseEntity.of(iMarcaCocheServicio.getMarcaCoche(id));
    }

    /**
     * Guarda una marca
     * @param marcaCocheDto marca cochea crear
     * @return Estado Ok
     */
    @PostMapping()
    public ResponseEntity<MarcaCocheDto> save(@RequestBody MarcaCocheDto marcaCocheDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iMarcaCocheServicio.save(marcaCocheDto));
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
    public ResponseEntity<MarcaCocheDto> update(@RequestBody MarcaCocheDto macaCochePojo) {

        MarcaCocheDto marcaCocheDto = iMarcaCocheServicio.update(macaCochePojo);

        if (marcaCocheDto == null) {
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

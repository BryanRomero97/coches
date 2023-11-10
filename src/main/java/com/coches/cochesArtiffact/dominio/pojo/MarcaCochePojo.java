package com.coches.cochesArtiffact.dominio.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.*;

/**
 * Clase Pojo de MarcaCoche
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MarcaCochePojo {

    private Integer id;

    private String description ;

}

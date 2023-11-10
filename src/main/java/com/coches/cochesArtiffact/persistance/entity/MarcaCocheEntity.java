package com.coches.cochesArtiffact.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Modelado de la entidad MarcaCoche
 */

@Entity
@Table(name = "marca_coche")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MarcaCocheEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion")
    private String description ;

}

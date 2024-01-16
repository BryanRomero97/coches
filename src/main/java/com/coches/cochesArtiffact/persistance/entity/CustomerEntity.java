package com.coches.cochesArtiffact.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad de cliente
 */

@Entity
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cedula")
    private String cardId;

    @Column(name = "nombre_completo")
    private String fullname;

    @Column(name = "correo")
    private String email;

    @Column(name = "numero_celular")
    private Double numberCellPhone;

    @Column(name = "activo")
    private Integer active;

    @Column(name = "contrasenia")
    private String password;
}

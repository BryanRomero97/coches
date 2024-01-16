package com.coches.cochesArtiffact.dominio.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO de cliente
 */

@Getter @Setter
public class CustomerDto {

    private String cardId;

    private String fullname;

    private String email;

    private Double numberCellPhone;

    private Integer active;

    private String password;


}

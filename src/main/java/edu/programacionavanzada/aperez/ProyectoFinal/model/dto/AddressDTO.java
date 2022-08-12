package edu.programacionavanzada.aperez.ProyectoFinal.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AddressDTO {

    private Long id;
    private String name;
    private String description;
}

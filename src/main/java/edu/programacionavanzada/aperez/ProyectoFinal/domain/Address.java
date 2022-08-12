package edu.programacionavanzada.aperez.ProyectoFinal.domain;

import edu.programacionavanzada.aperez.ProyectoFinal.model.dto.AddressDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    public AddressDTO toDTO() {
        return AddressDTO.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();
    }

}
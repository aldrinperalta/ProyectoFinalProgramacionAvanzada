package edu.programacionavanzada.aperez.ProyectoFinal.domain;


import lombok.*;
import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "addresses")

public class address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
    @Column
    private String description;



}

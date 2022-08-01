package edu.programacionavanzada.aperez.ProyectoFinal.domain;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "checkouts")

public class checkout {
    @Id
    private UUID id;

    //private List<Product> products;



}

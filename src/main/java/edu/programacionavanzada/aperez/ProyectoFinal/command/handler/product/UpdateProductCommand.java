package edu.programacionavanzada.aperez.ProyectoFinal.command.handler.product;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.product.UpdateProductResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateProductCommand extends Command<UpdateProductResponse> {

    private Long id;
    private String description;
    private long availableQuantity;
    private BigDecimal price;
}
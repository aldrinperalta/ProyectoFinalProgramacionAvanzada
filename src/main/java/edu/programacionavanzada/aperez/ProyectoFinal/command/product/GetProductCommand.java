package edu.programacionavanzada.aperez.ProyectoFinal.command.product;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.product.GetProductResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetProductCommand extends Command<GetProductResponse> {

    private Long id;
}
package edu.programacionavanzada.aperez.ProyectoFinal.command.product;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.product.DeleteProductResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeleteProductCommand extends Command<DeleteProductResponse> {

    private Long id;
}

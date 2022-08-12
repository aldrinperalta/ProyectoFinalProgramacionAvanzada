package edu.programacionavanzada.aperez.ProyectoFinal.command.handler.product;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.product.GetProductResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class GetAllProductCommand extends Command<GetProductResponse> {

    private int pageSize;
    private int page;

}
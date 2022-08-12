package edu.programacionavanzada.aperez.ProyectoFinal.command.order;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.order.GetOrderResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class GetAllOrderCommand extends Command<GetOrderResponse> {

    private int pageSize;
    private int page;
}

package edu.programacionavanzada.aperez.ProyectoFinal.command.order;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.order.GetOrderResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetOrderCommand extends Command<GetOrderResponse> {

    private UUID id;
}
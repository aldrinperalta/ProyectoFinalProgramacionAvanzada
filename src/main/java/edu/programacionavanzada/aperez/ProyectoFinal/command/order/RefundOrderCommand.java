package edu.programacionavanzada.aperez.ProyectoFinal.command.order;

import edu.programacionavanzada.aperez.ProyectoFinal.domain.Order;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.order.RefundOrderResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaPayLoadKey;
import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RefundOrderCommand extends Command<RefundOrderResponse> {

    public static final SagaPayLoadKey<UUID> ID = new SagaPayLoadKey<>("id", UUID.class);
    public static final SagaPayLoadKey<RefundOrderCommand> COMMAND = new SagaPayLoadKey<>("command", RefundOrderCommand.class);
    public static final SagaPayLoadKey<Order> ORDER = new SagaPayLoadKey<>("order", Order.class);

    private UUID id;
}
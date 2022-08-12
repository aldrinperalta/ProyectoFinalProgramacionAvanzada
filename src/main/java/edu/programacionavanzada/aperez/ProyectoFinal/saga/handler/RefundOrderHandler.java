package edu.programacionavanzada.aperez.ProyectoFinal.saga.handler;

import edu.programacionavanzada.aperez.ProyectoFinal.command.order.RefundOrderCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.domain.Order;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.order.RefundOrderResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaPayload;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStepHandler;
import edu.programacionavanzada.aperez.ProyectoFinal.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class RefundOrderHandler implements SagaStepHandler<RefundOrderResponse> {

    private final OrderRepository orderRepository;

    @Override
    public void handle(SagaPayload<RefundOrderResponse> sagaPayload) {
        Order order = sagaPayload.getProperty(RefundOrderCommand.ORDER);
        order.setRefund(true);
        // Hago la devolución del dinero llamando al API correspondiente.
        orderRepository.save(order);
        sagaPayload.setResult(RefundOrderResponse.builder().build());
    }
}
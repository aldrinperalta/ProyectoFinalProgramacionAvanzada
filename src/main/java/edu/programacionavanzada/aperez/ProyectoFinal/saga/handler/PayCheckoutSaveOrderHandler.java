package edu.programacionavanzada.aperez.ProyectoFinal.saga.handler;

import edu.programacionavanzada.aperez.ProyectoFinal.command.checkout.PayCheckoutCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.domain.Order;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout.PayCheckoutResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaPayload;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStepHandler;
import edu.programacionavanzada.aperez.ProyectoFinal.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class PayCheckoutSaveOrderHandler implements SagaStepHandler<PayCheckoutResponse> {

    private final OrderRepository orderRepository;

    @Override
    public void handle(SagaPayload<PayCheckoutResponse> sagaPayload) {
        Order order = sagaPayload.getProperty(PayCheckoutCommand.ORDER);
        orderRepository.save(order);
        sagaPayload.setResult(PayCheckoutResponse.builder().orderDTO(order.toDTO()).build());
    }
}
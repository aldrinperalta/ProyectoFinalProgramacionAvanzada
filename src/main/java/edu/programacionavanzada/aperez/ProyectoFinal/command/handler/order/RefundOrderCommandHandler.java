package edu.programacionavanzada.aperez.ProyectoFinal.command.handler.order;

import edu.programacionavanzada.aperez.ProyectoFinal.command.order.RefundOrderCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.order.RefundOrderResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.SagaOrchestrator;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.Saga;
import edu.programacionavanzada.aperez.ProyectoFinal.saga.SagaFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@CommandEvent(command = RefundOrderCommand.class)
@Slf4j
public class RefundOrderCommandHandler implements CommandHandler<RefundOrderResponse, RefundOrderCommand> {

    private final SagaOrchestrator sagaOrchestrator;

    @Value("${pattern.saga.timeout}")
    private int timeout;

    @Override
    public RefundOrderResponse handle(RefundOrderCommand refundPayCheckoutCommand) {
        Saga<RefundOrderResponse> saga = SagaFactory.refundOrderSaga(UUID.randomUUID(), refundPayCheckoutCommand);
        return sagaOrchestrator.orchestrate(saga, timeout);
    }
}
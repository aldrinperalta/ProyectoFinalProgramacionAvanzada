package edu.programacionavanzada.aperez.ProyectoFinal.saga.step;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.order.RefundOrderResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStep;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStepCompensator;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStepHandler;
import edu.programacionavanzada.aperez.ProyectoFinal.saga.handler.RefundOrderHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
@Slf4j
public class RefundOrderStep implements SagaStep<RefundOrderResponse> {

    private final RefundOrderHandler refundOrderHandler;

    @Override
    public String getName() {
        return "Refund Order";
    }

    @Override
    public SagaStepHandler<RefundOrderResponse> getHandler() {
        return refundOrderHandler;
    }

    @Override
    public SagaStepCompensator<RefundOrderResponse> getCompensator() {
        return null;
    }
}
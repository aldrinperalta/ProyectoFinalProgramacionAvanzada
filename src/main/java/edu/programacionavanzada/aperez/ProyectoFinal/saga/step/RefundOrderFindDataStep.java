package edu.programacionavanzada.aperez.ProyectoFinal.saga.step;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.order.RefundOrderResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStep;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStepCompensator;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStepHandler;
import edu.programacionavanzada.aperez.ProyectoFinal.saga.handler.RefundOrderFindDataHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
@Slf4j
public class RefundOrderFindDataStep implements SagaStep<RefundOrderResponse> {

    private final RefundOrderFindDataHandler refundOrderFindDataHandler;

    @Override
    public String getName() {
        return "Find Data";
    }

    @Override
    public SagaStepHandler<RefundOrderResponse> getHandler() {
        return refundOrderFindDataHandler;
    }

    @Override
    public SagaStepCompensator<RefundOrderResponse> getCompensator() {
        return null;
    }
}
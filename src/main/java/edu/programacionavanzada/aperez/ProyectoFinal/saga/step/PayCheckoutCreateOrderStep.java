package edu.programacionavanzada.aperez.ProyectoFinal.saga.step;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout.PayCheckoutResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStep;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStepCompensator;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStepHandler;
import edu.programacionavanzada.aperez.ProyectoFinal.saga.handler.PayCheckoutCreateOrderHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
@Slf4j
public class PayCheckoutCreateOrderStep implements SagaStep<PayCheckoutResponse> {

    private final PayCheckoutCreateOrderHandler payCheckoutCreateOrderHandler;

    @Override
    public String getName() {
        return "Create Order";
    }

    @Override
    public SagaStepHandler<PayCheckoutResponse> getHandler() {
        return payCheckoutCreateOrderHandler;
    }

    @Override
    public SagaStepCompensator<PayCheckoutResponse> getCompensator() {
        return null;
    }
}
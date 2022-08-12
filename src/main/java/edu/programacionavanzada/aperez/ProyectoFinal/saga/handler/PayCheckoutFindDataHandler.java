package edu.programacionavanzada.aperez.ProyectoFinal.saga.handler;

import edu.programacionavanzada.aperez.ProyectoFinal.command.checkout.PayCheckoutCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.domain.Checkout;
import edu.programacionavanzada.aperez.ProyectoFinal.model.exceptions.CheckoutNoFoundException;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout.PayCheckoutResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaPayload;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStepHandler;
import edu.programacionavanzada.aperez.ProyectoFinal.repositories.CheckoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class PayCheckoutFindDataHandler implements SagaStepHandler<PayCheckoutResponse> {

    private final CheckoutRepository checkoutRepository;

    @Override
    public void handle(SagaPayload<PayCheckoutResponse> sagaPayload) {
        PayCheckoutCommand command = sagaPayload.getProperty(PayCheckoutCommand.COMMAND);
        Checkout checkout = checkoutRepository.findById(command.getId()).orElseThrow(() -> new CheckoutNoFoundException(command.getId()));

        sagaPayload.addProperty(PayCheckoutCommand.CHECKOUT, checkout);
    }
}
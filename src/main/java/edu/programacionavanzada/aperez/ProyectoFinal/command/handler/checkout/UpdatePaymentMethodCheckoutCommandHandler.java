package edu.programacionavanzada.aperez.ProyectoFinal.command.handler.checkout;

import edu.programacionavanzada.aperez.ProyectoFinal.command.checkout.UpdatePaymentMethodCheckoutCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.domain.Checkout;
import edu.programacionavanzada.aperez.ProyectoFinal.domain.PaymentMethod;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout.CheckoutUpdatePaymentMethodResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacionavanzada.aperez.ProyectoFinal.repositories.CheckoutRepository;
import edu.programacionavanzada.aperez.ProyectoFinal.repositories.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@CommandEvent(command = UpdatePaymentMethodCheckoutCommand.class)
@Slf4j
public class UpdatePaymentMethodCheckoutCommandHandler implements CommandHandler<CheckoutUpdatePaymentMethodResponse, UpdatePaymentMethodCheckoutCommand> {

    private final PaymentMethodRepository paymentMethodRepository;
    private final CheckoutRepository checkoutRepository;

    @Override
    public CheckoutUpdatePaymentMethodResponse handle(UpdatePaymentMethodCheckoutCommand updatePaymentMethodCheckoutCommand) {
        log.debug("Update Payment Method to Checkout {}", updatePaymentMethodCheckoutCommand.getId());
        Checkout checkout = checkoutRepository.findById(updatePaymentMethodCheckoutCommand.getId()).orElseThrow();
        PaymentMethod paymentMethod = paymentMethodRepository.findById(updatePaymentMethodCheckoutCommand.getPaymentMethod()).orElseThrow();
        checkout.setPaymentMethod(paymentMethod);
        checkoutRepository.save(checkout);
        return CheckoutUpdatePaymentMethodResponse.builder()
                .checkout(checkout.toDTO())
                .build();
    }
}
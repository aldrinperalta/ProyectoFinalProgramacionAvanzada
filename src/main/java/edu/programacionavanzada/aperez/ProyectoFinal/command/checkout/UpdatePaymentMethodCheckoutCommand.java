package edu.programacionavanzada.aperez.ProyectoFinal.command.checkout;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout.CheckoutUpdatePaymentMethodResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdatePaymentMethodCheckoutCommand extends Command<CheckoutUpdatePaymentMethodResponse> {

    private UUID id;
    private Long paymentMethod;
}
package edu.programacionavanzada.aperez.ProyectoFinal.model.request.checkout;

import edu.programacionavanzada.aperez.ProyectoFinal.command.checkout.UpdatePaymentMethodCheckoutCommand;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CheckoutUpdatePaymentMethodRequest {

    @NotNull
    private UUID id;

    @NotNull
    @Positive
    private Long paymentMethod;

    public UpdatePaymentMethodCheckoutCommand toCommand() {
        return UpdatePaymentMethodCheckoutCommand.builder()
                .id(id)
                .paymentMethod(paymentMethod)
                .build();
    }
}

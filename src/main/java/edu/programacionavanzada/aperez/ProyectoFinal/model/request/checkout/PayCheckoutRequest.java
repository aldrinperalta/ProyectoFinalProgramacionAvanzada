package edu.programacionavanzada.aperez.ProyectoFinal.model.request.checkout;

import edu.programacionavanzada.aperez.ProyectoFinal.command.checkout.PayCheckoutCommand;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PayCheckoutRequest {

    @NotNull
    private UUID id;

    public PayCheckoutCommand toCommand() {
        return PayCheckoutCommand.builder()
                .id(id)
                .build();
    }
}
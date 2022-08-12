package edu.programacionavanzada.aperez.ProyectoFinal.model.request.checkout;

import edu.programacionavanzada.aperez.ProyectoFinal.command.checkout.UpdateAddressCheckoutCommand;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CheckoutUpdateAddressRequest {

    @NotNull
    private UUID id;

    @NotNull
    @Positive
    private Long address;

    public UpdateAddressCheckoutCommand toCommand() {
        return UpdateAddressCheckoutCommand.builder()
                .id(id)
                .address(address)
                .build();
    }
}
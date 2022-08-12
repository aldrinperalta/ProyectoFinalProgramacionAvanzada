package edu.programacionavanzada.aperez.ProyectoFinal.command.checkout;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout.CheckoutUpdateAddressResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateAddressCheckoutCommand extends Command<CheckoutUpdateAddressResponse> {

    private UUID id;
    private Long address;
}
package edu.programacionavanzada.aperez.ProyectoFinal.command.checkout;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout.CheckoutAddProductResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AddProductCheckoutCommand extends Command<CheckoutAddProductResponse> {

    private UUID id;
    private Long product;
    private Long quantity;
}
package edu.programacionavanzada.aperez.ProyectoFinal.model.request.checkout;

import edu.programacionavanzada.aperez.ProyectoFinal.command.checkout.AddProductCheckoutCommand;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CheckoutAddProductRequest {

    @NotNull
    private UUID id;
    @NotNull
    @Positive
    private Long product;
    @NotNull
    @Positive
    private Long quantity;

    public AddProductCheckoutCommand toCommand() {
        return AddProductCheckoutCommand.builder()
                .id(id)
                .product(product)
                .quantity(quantity)
                .build();
    }
}
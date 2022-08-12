package edu.programacionavanzada.aperez.ProyectoFinal.model.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CheckoutDTO {

    private UUID id;
    private AddressDTO address;
    private PaymentMethodDTO paymentMethod;
    private List<CheckoutProductDTO> productsToBuy;
}
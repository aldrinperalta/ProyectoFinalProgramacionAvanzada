package edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout;

import edu.programacionavanzada.aperez.ProyectoFinal.model.dto.CheckoutDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CheckoutAddProductResponse {

    private CheckoutDTO checkout;
}
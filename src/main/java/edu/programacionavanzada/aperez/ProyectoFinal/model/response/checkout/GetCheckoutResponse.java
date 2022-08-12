package edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout;

import edu.programacionavanzada.aperez.ProyectoFinal.model.dto.CheckoutDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetCheckoutResponse {

    private List<CheckoutDTO> checkouts;
}
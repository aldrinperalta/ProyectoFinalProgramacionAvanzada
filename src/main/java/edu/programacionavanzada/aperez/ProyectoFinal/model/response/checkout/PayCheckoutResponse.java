package edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout;

import edu.programacionavanzada.aperez.ProyectoFinal.model.dto.OrderDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PayCheckoutResponse {

    private OrderDTO orderDTO;
}
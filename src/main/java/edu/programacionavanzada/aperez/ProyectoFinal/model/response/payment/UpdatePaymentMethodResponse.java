package edu.programacionavanzada.aperez.ProyectoFinal.model.response.payment;

import edu.programacionavanzada.aperez.ProyectoFinal.model.dto.PaymentMethodDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdatePaymentMethodResponse {

    private PaymentMethodDTO paymentMethod;
}
package edu.programacionavanzada.aperez.ProyectoFinal.model.response.payment;

import edu.programacionavanzada.aperez.ProyectoFinal.model.dto.PaymentMethodDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetPaymentMethodResponse {

    private List<PaymentMethodDTO> paymentMethods;
}
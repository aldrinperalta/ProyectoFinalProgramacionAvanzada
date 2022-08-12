package edu.programacionavanzada.aperez.ProyectoFinal.command.payment;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.payment.GetPaymentMethodResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetPaymentMethodCommand extends Command<GetPaymentMethodResponse> {

    private Long id;
}
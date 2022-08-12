package edu.programacionavanzada.aperez.ProyectoFinal.command.payment;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.payment.DeletePaymentMethodResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeletePaymentMethodCommand extends Command<DeletePaymentMethodResponse> {

    private Long id;
}
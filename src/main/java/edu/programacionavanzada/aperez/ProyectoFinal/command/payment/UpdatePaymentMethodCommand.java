package edu.programacionavanzada.aperez.ProyectoFinal.command.payment;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.payment.UpdatePaymentMethodResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdatePaymentMethodCommand extends Command<UpdatePaymentMethodResponse> {

    private Long id;
    private String description;
}

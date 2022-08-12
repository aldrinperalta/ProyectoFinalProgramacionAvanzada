package edu.programacionavanzada.aperez.ProyectoFinal.command.payment;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.payment.GetPaymentMethodResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class GetAllPaymentMethodCommand extends Command<GetPaymentMethodResponse> {

    private int pageSize;
    private int page;
}

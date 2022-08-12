package edu.programacionavanzada.aperez.ProyectoFinal.command.payment;

import edu.programacionavanzada.aperez.ProyectoFinal.domain.PaymentMethod;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.payment.CreatePaymentMethodResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreatePaymentMethodCommand extends Command<CreatePaymentMethodResponse> {

    private String name;
    private String description;

    public PaymentMethod toPaymentMethod() {
        return PaymentMethod.builder()
                .name(name)
                .description(description)
                .build();
    }

}
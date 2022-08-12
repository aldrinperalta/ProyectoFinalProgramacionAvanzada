package edu.programacionavanzada.aperez.ProyectoFinal.model.request.payment;

import edu.programacionavanzada.aperez.ProyectoFinal.command.handler.payment.UpdatePaymentMethodCommand;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdatePaymentMethodRequest {

    @NotNull
    @Positive
    private Long id;
    private String description;

    public UpdatePaymentMethodCommand toCommand() {
        return UpdatePaymentMethodCommand.builder()
                .id(id)
                .description(description)
                .build();
    }
}

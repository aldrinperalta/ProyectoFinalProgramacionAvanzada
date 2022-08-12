package edu.programacionavanzada.aperez.ProyectoFinal.model.request.payment;

import edu.programacionavanzada.aperez.ProyectoFinal.command.handler.payment.DeletePaymentMethodCommand;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeletePaymentMethodRequest {

    @NotNull
    @Positive
    private Long id;

    public DeletePaymentMethodCommand toCommand() {
        return DeletePaymentMethodCommand.builder()
                .id(id)
                .build();
    }
}

package edu.programacionavanzada.aperez.ProyectoFinal.model.request.payment;

import edu.programacionavanzada.aperez.ProyectoFinal.command.handler.payment.CreatePaymentMethodCommand;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreatePaymentMethodRequest {

    @Size(min = 4, max = 10)
    @NotBlank(message = "Campo name no puede estar vacío")
    private String name;
    private String description;

    public CreatePaymentMethodCommand toCommand() {
        return CreatePaymentMethodCommand.builder()
                .name(name)
                .description(description)
                .build();
    }
}

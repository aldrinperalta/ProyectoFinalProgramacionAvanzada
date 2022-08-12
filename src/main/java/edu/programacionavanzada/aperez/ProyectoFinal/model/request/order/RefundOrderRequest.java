package edu.programacionavanzada.aperez.ProyectoFinal.model.request.order;

import edu.programacionavanzada.aperez.ProyectoFinal.command.order.RefundOrderCommand;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RefundOrderRequest {

    @NotNull
    private UUID id;

    public RefundOrderCommand toCommand() {
        return RefundOrderCommand.builder()
                .id(id)
                .build();
    }
}
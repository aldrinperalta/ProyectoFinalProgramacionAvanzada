package edu.programacionavanzada.aperez.ProyectoFinal.model.request.address;

import edu.programacionavanzada.aperez.ProyectoFinal.command.address.DeleteAddressCommand;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeleteAddressRequest {

    @NotNull
    @Positive
    private Long id;

    public DeleteAddressCommand toCommand() {
        return DeleteAddressCommand.builder()
                .id(id)
                .build();
    }
}
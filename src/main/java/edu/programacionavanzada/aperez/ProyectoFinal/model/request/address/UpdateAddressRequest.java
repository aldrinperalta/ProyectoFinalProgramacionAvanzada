package edu.programacionavanzada.aperez.ProyectoFinal.model.request.address;

import edu.programacionavanzada.aperez.ProyectoFinal.command.address.UpdateAddressCommand;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateAddressRequest {

    @NotNull
    @Positive
    private Long id;

    @Size(min = 4, max = 10)
    @NotBlank(message = "Campo name no puede estar vacío")
    private String name;
    private String description;

    public UpdateAddressCommand toCommand() {
        return UpdateAddressCommand.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();
    }

}
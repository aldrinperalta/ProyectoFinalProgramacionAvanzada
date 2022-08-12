package edu.programacionavanzada.aperez.ProyectoFinal.command.address;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.adress.UpdateAddressResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateAddressCommand extends Command<UpdateAddressResponse> {

    private Long id;
    private String name;
    private String description;
}
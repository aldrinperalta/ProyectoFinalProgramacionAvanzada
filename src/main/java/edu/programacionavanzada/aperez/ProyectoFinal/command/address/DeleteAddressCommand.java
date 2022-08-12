package edu.programacionavanzada.aperez.ProyectoFinal.command.address;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.adress.DeleteAddressResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeleteAddressCommand extends Command<DeleteAddressResponse> {

    private Long id;
}
package edu.programacionavanzada.aperez.ProyectoFinal.command.address;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.adress.GetAddressResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetAddressCommand extends Command<GetAddressResponse> {

    private Long id;
}
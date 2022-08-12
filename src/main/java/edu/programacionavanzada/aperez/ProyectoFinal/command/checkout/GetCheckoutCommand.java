package edu.programacionavanzada.aperez.ProyectoFinal.command.checkout;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout.GetCheckoutResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetCheckoutCommand extends Command<GetCheckoutResponse> {

    private UUID id;
}
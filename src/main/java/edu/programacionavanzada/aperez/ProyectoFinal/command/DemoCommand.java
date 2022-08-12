package edu.programacionavanzada.aperez.ProyectoFinal.command;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.DemoResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DemoCommand extends Command<DemoResponse> {

    private boolean explote;
}
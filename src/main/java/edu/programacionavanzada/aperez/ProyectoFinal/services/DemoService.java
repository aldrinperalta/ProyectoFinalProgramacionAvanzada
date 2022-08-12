package edu.programacionavanzada.aperez.ProyectoFinal.services;

import edu.programacionavanzada.aperez.ProyectoFinal.command.DemoCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DemoService {

    private final CommandBus commandBus;

    public DemoResponse get(boolean explote) {
        return commandBus.sendCommand(DemoCommand.builder().explote(explote).build());
    }
}
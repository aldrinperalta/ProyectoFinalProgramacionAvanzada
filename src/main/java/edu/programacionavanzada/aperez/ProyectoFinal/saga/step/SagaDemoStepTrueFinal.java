package edu.programacionavanzada.aperez.ProyectoFinal.saga.step;

import edu.programacionavanzada.aperez.ProyectoFinal.command.DemoCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.model.exceptions.BadSagaException;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.DemoResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaPayLoadKey;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStep;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStepCompensator;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStepHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class SagaDemoStepTrueFinal implements SagaStep<DemoResponse> {

    @Override
    public String getName() {
        return "Demo Step true final";
    }

    @Override
    public SagaStepHandler<DemoResponse> getHandler() {
        return sagaPayload -> {
            DemoCommand command = sagaPayload.getProperty(new SagaPayLoadKey<>("command", DemoCommand.class));
            log.info("Running {} Handler", getName());
            if (command.isExplote()) {
                throw new BadSagaException();
            }
            sagaPayload.setResult(DemoResponse.builder().data("Wiiii complete!").build());
        };
    }

    @Override
    public SagaStepCompensator<DemoResponse> getCompensator() {
        return null;
    }
}

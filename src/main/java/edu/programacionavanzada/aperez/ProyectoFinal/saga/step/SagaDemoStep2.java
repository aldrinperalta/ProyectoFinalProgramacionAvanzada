package edu.programacionavanzada.aperez.ProyectoFinal.saga.step;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.DemoResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStep;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStepCompensator;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStepHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class SagaDemoStep2 implements SagaStep<DemoResponse> {

    @Override
    public String getName() {
        return "Demo Step 2";
    }

    @Override
    public SagaStepHandler<DemoResponse> getHandler() {
        return sagaPayload -> {
            log.info("Running {} Handler", getName());
        };
    }

    @Override
    public SagaStepCompensator<DemoResponse> getCompensator() {
        return sagaPayload -> {
            log.info("Running {} compensator", getName());
            log.info("Only show 2 comments here");
        };
    }
}
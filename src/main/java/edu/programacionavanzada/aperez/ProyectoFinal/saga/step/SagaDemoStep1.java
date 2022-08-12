package edu.programacionavanzada.aperez.ProyectoFinal.saga.step;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.DemoResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaPayLoadKey;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStep;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStepCompensator;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaStepHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
@Slf4j
public class SagaDemoStep1 implements SagaStep<DemoResponse> {

    @Override
    public String getName() {
        return "Demo Step 1";
    }

    @Override
    public SagaStepHandler<DemoResponse> getHandler() {
        return sagaPayload -> {
            log.info("Running {} Handler", getName());
            System.out.println("Testing Demo Handler");
            sagaPayload.addProperty(new SagaPayLoadKey<>("decimal", BigDecimal.class), new BigDecimal(500));
        };
    }

    @Override
    public SagaStepCompensator<DemoResponse> getCompensator() {
        return sagaPayload -> {
            log.info("Running {} compensator", getName());
            log.info("Fallando epicamente!");
        };
    }
}
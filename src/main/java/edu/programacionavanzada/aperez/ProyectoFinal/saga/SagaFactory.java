package edu.programacionavanzada.aperez.ProyectoFinal.saga;

import edu.programacionavanzada.aperez.ProyectoFinal.command.DemoCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.command.checkout.PayCheckoutCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.command.order.RefundOrderCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.DemoResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout.PayCheckoutResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.order.RefundOrderResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.Saga;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaPayLoadKey;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model.SagaPayload;
import edu.programacionavanzada.aperez.ProyectoFinal.saga.step.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SagaFactory {

    public static Saga<DemoResponse> createDemoSaga(UUID key, DemoCommand command) {
        SagaPayload<DemoResponse> sagaPayload = new SagaPayload<>();
        sagaPayload.addProperty(new SagaPayLoadKey<>("command", DemoCommand.class), command);
        return Saga.<DemoResponse>builder()
                .name("Demo Saga")
                .key(key)
                .payload(sagaPayload)
                .requiredStep(List.of(
                        SagaDemoStep1.class,
                        SagaDemoStep2.class,
                        SagaDemoStepFinal.class,
                        SagaDemoStepTrueFinal.class
                ))
                .build();
    }

    public static Saga<PayCheckoutResponse> payCheckoutSaga(UUID key, PayCheckoutCommand command) {
        SagaPayload<PayCheckoutResponse> sagaPayload = new SagaPayload<>();
        sagaPayload.addProperty(PayCheckoutCommand.ID, key);
        sagaPayload.addProperty(PayCheckoutCommand.COMMAND, command);
        return Saga.<PayCheckoutResponse>builder()
                .name("Pay Checkout Saga")
                .key(key)
                .payload(sagaPayload)
                .requiredStep(List.of(
                        PayCheckoutFindDataStep.class,
                        PayCheckoutCreateOrderStep.class,
                        PayCheckoutSaveOrderStep.class
                ))
                .build();
    }

    public static Saga<RefundOrderResponse> refundOrderSaga(UUID key, RefundOrderCommand command) {
        SagaPayload<RefundOrderResponse> sagaPayload = new SagaPayload<>();
        sagaPayload.addProperty(RefundOrderCommand.ID, key);
        sagaPayload.addProperty(RefundOrderCommand.COMMAND, command);
        return Saga.<RefundOrderResponse>builder()
                .name("Refund Order Saga")
                .key(key)
                .payload(sagaPayload)
                .requiredStep(List.of(
                        RefundOrderFindDataStep.class,
                        RefundOrderStep.class
                ))
                .build();
    }
}
package edu.programacionavanzada.aperez.ProyectoFinal.services;

import edu.programacionavanzada.aperez.ProyectoFinal.model.request.payment.CreatePaymentMethodRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.request.payment.DeletePaymentMethodRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.request.payment.UpdatePaymentMethodRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.payment.CreatePaymentMethodResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.payment.DeletePaymentMethodResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.payment.GetPaymentMethodResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.payment.UpdatePaymentMethodResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PaymentMethodService {

    private final CommandBus commandBus;

    public GetPaymentMethodResponse getAll(Integer pageSize, Integer page) {
        return commandBus.sendCommand(GetAllPaymentMethodCommand.builder()
                .pageSize(pageSize)
                .page(page)
                .build());
    }

    public GetPaymentMethodResponse get(Long id) {
        return commandBus.sendCommand(GetPaymentMethodCommand.builder()
                .id(id)
                .build());
    }

    public CreatePaymentMethodResponse create(CreatePaymentMethodRequest createPaymentMethodRequest) {
        return commandBus.sendCommand(createPaymentMethodRequest.toCommand());
    }

    public UpdatePaymentMethodResponse update(UpdatePaymentMethodRequest updatePaymentMethodRequest) {
        return commandBus.sendCommand(updatePaymentMethodRequest.toCommand());
    }

    public DeletePaymentMethodResponse delete(DeletePaymentMethodRequest deletePaymentMethodRequest) {
        return commandBus.sendCommand(deletePaymentMethodRequest.toCommand());
    }
}
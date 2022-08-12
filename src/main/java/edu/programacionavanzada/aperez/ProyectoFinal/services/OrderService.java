package edu.programacionavanzada.aperez.ProyectoFinal.services;

import edu.programacionavanzada.aperez.ProyectoFinal.model.response.order.GetOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final CommandBus commandBus;

    public GetOrderResponse getAll(Integer pageSize, Integer page) {
        return commandBus.sendCommand(GetAllOrderCommand.builder()
                .pageSize(pageSize)
                .page(page)
                .build());
    }

    public GetOrderResponse get(UUID id) {
        return commandBus.sendCommand(GetOrderCommand.builder()
                .id(id)
                .build());
    }
}

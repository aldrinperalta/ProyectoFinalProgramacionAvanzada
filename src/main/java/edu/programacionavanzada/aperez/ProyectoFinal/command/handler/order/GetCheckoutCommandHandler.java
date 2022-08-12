package edu.programacionavanzada.aperez.ProyectoFinal.command.handler.order;

import edu.programacionavanzada.aperez.ProyectoFinal.command.order.GetOrderCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.model.dto.OrderDTO;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.order.GetOrderResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacionavanzada.aperez.ProyectoFinal.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@CommandEvent(command = GetOrderCommand.class)
@Slf4j
public class GetCheckoutCommandHandler implements CommandHandler<GetOrderResponse, GetOrderCommand> {

    private final OrderRepository orderRepository;

    @Override
    public GetOrderResponse handle(GetOrderCommand getOrderCommand) {
        log.debug("Get orders {}", getOrderCommand.getId());
        OrderDTO orderDTO = orderRepository.findById(getOrderCommand.getId()).orElseThrow().toDTO();
        return GetOrderResponse.builder()
                .orders(List.of(orderDTO))
                .build();
    }
}
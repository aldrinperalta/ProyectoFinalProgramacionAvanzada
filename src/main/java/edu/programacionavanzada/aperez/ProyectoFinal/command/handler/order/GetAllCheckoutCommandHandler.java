package edu.programacionavanzada.aperez.ProyectoFinal.command.handler.order;

import edu.programacionavanzada.aperez.ProyectoFinal.command.order.GetAllOrderCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.domain.Order;
import edu.programacionavanzada.aperez.ProyectoFinal.model.dto.OrderDTO;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.order.GetOrderResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacionavanzada.aperez.ProyectoFinal.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
@CommandEvent(command = GetAllOrderCommand.class)
@Slf4j
public class GetAllCheckoutCommandHandler implements CommandHandler<GetOrderResponse, GetAllOrderCommand> {

    private final OrderRepository orderRepository;

    @Override
    public GetOrderResponse handle(GetAllOrderCommand getAllOrderCommand) {
        log.debug("Get Orders {}", getAllOrderCommand.toString());
        List<OrderDTO> orders = orderRepository.findAll(
                        PageRequest.of(getAllOrderCommand.getPage(), getAllOrderCommand.getPageSize()))
                .stream()
                .map(Order::toDTO)
                .collect(Collectors.toList());
        return GetOrderResponse.builder()
                .orders(orders)
                .build();
    }
}
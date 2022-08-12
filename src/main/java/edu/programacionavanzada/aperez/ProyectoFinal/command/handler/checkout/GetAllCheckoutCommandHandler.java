package edu.programacionavanzada.aperez.ProyectoFinal.command.handler.checkout;

import edu.programacionavanzada.aperez.ProyectoFinal.command.checkout.GetAllCheckoutCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.domain.Checkout;
import edu.programacionavanzada.aperez.ProyectoFinal.model.dto.CheckoutDTO;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout.GetCheckoutResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacionavanzada.aperez.ProyectoFinal.repositories.CheckoutRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
@CommandEvent(command = GetAllCheckoutCommand.class)
@Slf4j
public class GetAllCheckoutCommandHandler implements CommandHandler<GetCheckoutResponse, GetAllCheckoutCommand> {

    private final CheckoutRepository checkoutRepository;

    @Override
    public GetCheckoutResponse handle(GetAllCheckoutCommand getAllCheckoutCommand) {
        log.debug("Get Checkouts {}", getAllCheckoutCommand.toString());
        List<CheckoutDTO> checkoutDTOS = checkoutRepository.findAll(
                        PageRequest.of(getAllCheckoutCommand.getPage(), getAllCheckoutCommand.getPageSize()))
                .stream()
                .map(Checkout::toDTO)
                .collect(Collectors.toList());
        return GetCheckoutResponse.builder()
                .checkouts(checkoutDTOS)
                .build();
    }
}
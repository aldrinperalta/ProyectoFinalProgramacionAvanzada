package edu.programacionavanzada.aperez.ProyectoFinal.command.handler.checkout;

import edu.programacionavanzada.aperez.ProyectoFinal.command.checkout.GetCheckoutCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.model.dto.CheckoutDTO;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout.GetCheckoutResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacionavanzada.aperez.ProyectoFinal.repositories.CheckoutRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@CommandEvent(command = GetCheckoutCommand.class)
@Slf4j
public class GetCheckoutCommandHandler implements CommandHandler<GetCheckoutResponse, GetCheckoutCommand> {

    private final CheckoutRepository checkoutRepository;

    @Override
    public GetCheckoutResponse handle(GetCheckoutCommand getCheckoutCommand) {
        log.debug("Get Checkout {}", getCheckoutCommand.getId());
        CheckoutDTO checkoutDTO = checkoutRepository.findById(getCheckoutCommand.getId()).orElseThrow().toDTO();
        return GetCheckoutResponse.builder()
                .checkouts(List.of(checkoutDTO))
                .build();
    }
}
package edu.programacionavanzada.aperez.ProyectoFinal.command.handler.checkout;

import edu.programacionavanzada.aperez.ProyectoFinal.command.checkout.UpdateAddressCheckoutCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.domain.Address;
import edu.programacionavanzada.aperez.ProyectoFinal.domain.Checkout;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout.CheckoutUpdateAddressResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacionavanzada.aperez.ProyectoFinal.repositories.AddressRepository;
import edu.programacionavanzada.aperez.ProyectoFinal.repositories.CheckoutRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@CommandEvent(command = UpdateAddressCheckoutCommand.class)
@Slf4j
public class UpdateAddressCheckoutCommandHandler implements CommandHandler<CheckoutUpdateAddressResponse, UpdateAddressCheckoutCommand> {

    private final AddressRepository addressRepository;
    private final CheckoutRepository checkoutRepository;

    @Override
    public CheckoutUpdateAddressResponse handle(UpdateAddressCheckoutCommand updateAddressCheckoutCommand) {
        log.debug("Update Address Checkout {}", updateAddressCheckoutCommand.getId());
        Checkout checkout = checkoutRepository.findById(updateAddressCheckoutCommand.getId()).orElseThrow();
        Address address = addressRepository.findById(updateAddressCheckoutCommand.getAddress()).orElseThrow();
        checkout.setAddress(address);
        checkoutRepository.save(checkout);
        return CheckoutUpdateAddressResponse.builder().checkout(checkout.toDTO()).build();
    }
}
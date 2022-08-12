package edu.programacionavanzada.aperez.ProyectoFinal.command.handler.address;

import edu.programacionavanzada.aperez.ProyectoFinal.command.address.UpdateAddressCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.domain.Address;
import edu.programacionavanzada.aperez.ProyectoFinal.model.exceptions.AddressNoFoundException;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.adress.UpdateAddressResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacionavanzada.aperez.ProyectoFinal.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@CommandEvent(command = UpdateAddressCommand.class)
@Slf4j
public class UpdateAddressCommandHandler implements CommandHandler<UpdateAddressResponse, UpdateAddressCommand> {

    private final AddressRepository addressRepository;

    @Override
    public UpdateAddressResponse handle(UpdateAddressCommand updateAddressCommand) {
        Address address = addressRepository.findById(updateAddressCommand.getId()).orElseThrow(() -> new AddressNoFoundException(updateAddressCommand.getId()));
        address.setName(updateAddressCommand.getName());
        address.setDescription(updateAddressCommand.getDescription());
        addressRepository.save(address);
        log.info("Address {} updated", updateAddressCommand.getId());
        return UpdateAddressResponse.builder().address(address.toDTO()).build();
    }
}
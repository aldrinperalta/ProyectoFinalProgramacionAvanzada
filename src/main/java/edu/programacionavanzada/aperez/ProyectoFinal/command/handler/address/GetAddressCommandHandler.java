package edu.programacionavanzada.aperez.ProyectoFinal.command.handler.address;


import edu.programacionavanzada.aperez.ProyectoFinal.command.address.GetAddressCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.model.dto.AddressDTO;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.adress.GetAddressResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacionavanzada.aperez.ProyectoFinal.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
@CommandEvent(command = GetAddressCommand.class)
@Slf4j
public class GetAddressCommandHandler implements CommandHandler<GetAddressResponse, GetAddressCommand> {

    private final AddressRepository addressRepository;

    @Override
    public GetAddressResponse handle(GetAddressCommand getAddressCommand) {
        log.debug("Get Address {}", getAddressCommand.getId());
        AddressDTO addressDTO = addressRepository.findById(getAddressCommand.getId()).orElseThrow().toDTO();
        return GetAddressResponse.builder()
                .addresses(List.of(addressDTO))
                .build();
    }
}
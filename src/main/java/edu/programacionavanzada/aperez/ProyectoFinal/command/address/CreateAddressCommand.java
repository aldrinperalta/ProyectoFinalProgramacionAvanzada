package edu.programacionavanzada.aperez.ProyectoFinal.command.address;


import edu.programacionavanzada.aperez.ProyectoFinal.domain.Address;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.adress.CreateAddressResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.Command;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateAddressCommand extends Command<CreateAddressResponse> {

    private String name;
    private String description;

    public Address toAddress() {
        return Address.builder()
                .name(name)
                .description(description)
                .build();
    }

}

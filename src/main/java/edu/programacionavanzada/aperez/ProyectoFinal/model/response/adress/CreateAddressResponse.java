package edu.programacionavanzada.aperez.ProyectoFinal.model.response.adress;

import edu.programacionavanzada.aperez.ProyectoFinal.model.dto.AddressDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateAddressResponse {

    private AddressDTO address;
}
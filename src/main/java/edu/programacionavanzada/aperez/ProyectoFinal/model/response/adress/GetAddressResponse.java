package edu.programacionavanzada.aperez.ProyectoFinal.model.response.adress;

import edu.programacionavanzada.aperez.ProyectoFinal.model.dto.AddressDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetAddressResponse {

    private List<AddressDTO> addresses;
}
package edu.programacionavanzada.aperez.ProyectoFinal.model.response.product;

import edu.programacionavanzada.aperez.ProyectoFinal.model.dto.ProductDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateProductResponse {

    private ProductDTO product;
}

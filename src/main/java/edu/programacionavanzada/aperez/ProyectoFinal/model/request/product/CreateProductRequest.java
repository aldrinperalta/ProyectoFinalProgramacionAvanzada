package edu.programacionavanzada.aperez.ProyectoFinal.model.request.product;

import edu.programacionavanzada.aperez.ProyectoFinal.command.product.CreateProductCommand;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateProductRequest {

    @Size(min = 4, max = 10)
    @NotBlank(message = "Campo name no puede estar vacío")
    private String name;
    private String description;
    @NotNull
    @PositiveOrZero
    private Long availableQuantity;
    @NotNull
    private BigDecimal price;

    public CreateProductCommand toCommand() {
        return CreateProductCommand.builder()
                .name(name)
                .description(description)
                .availableQuantity(availableQuantity)
                .price(price)
                .build();
    }
}
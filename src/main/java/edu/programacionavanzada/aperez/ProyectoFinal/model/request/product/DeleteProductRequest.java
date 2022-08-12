package edu.programacionavanzada.aperez.ProyectoFinal.model.request.product;

import edu.programacionavanzada.aperez.ProyectoFinal.command.product.DeleteProductCommand;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeleteProductRequest {

    @NotNull
    @Positive
    private Long id;

    public DeleteProductCommand toCommand() {
        return DeleteProductCommand.builder()
                .id(id)
                .build();
    }
}
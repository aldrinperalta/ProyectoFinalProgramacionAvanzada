package edu.programacionavanzada.aperez.ProyectoFinal.services;

import edu.programacionavanzada.aperez.ProyectoFinal.command.product.GetAllProductCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.command.product.GetProductCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.model.request.product.CreateProductRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.request.product.DeleteProductRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.request.product.UpdateProductRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.product.CreateProductResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.product.DeleteProductResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.product.GetProductResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.product.UpdateProductResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author aluis on 7/10/2022.
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final CommandBus commandBus;

    public GetProductResponse getAll(Integer pageSize, Integer page) {
        return commandBus.sendCommand(GetAllProductCommand.builder()
                .pageSize(pageSize)
                .page(page)
                .build());
    }

    public GetProductResponse get(Long id) {
        return commandBus.sendCommand(GetProductCommand.builder().id(id).build());
    }

    public CreateProductResponse create(CreateProductRequest createProductRequest) {
        return commandBus.sendCommand(createProductRequest.toCommand());
    }

    public UpdateProductResponse update(UpdateProductRequest updateProductRequest) {
        return commandBus.sendCommand(updateProductRequest.toCommand());
    }

    public DeleteProductResponse delete(DeleteProductRequest deleteProductRequest) {
        return commandBus.sendCommand(deleteProductRequest.toCommand());
    }
}
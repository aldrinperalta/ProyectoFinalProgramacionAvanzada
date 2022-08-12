package edu.programacionavanzada.aperez.ProyectoFinal.controller;

import edu.programacionavanzada.aperez.ProyectoFinal.model.request.product.CreateProductRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.request.product.DeleteProductRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.request.product.UpdateProductRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.product.CreateProductResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.product.DeleteProductResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.product.GetProductResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.product.UpdateProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<GetProductResponse> get(@RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                  @RequestParam(required = false, defaultValue = "0") Integer page) {
        return ResponseEntity.ok(productService.getAll(pageSize, page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(productService.get(id));
    }

    @PostMapping
    public ResponseEntity<CreateProductResponse> create(@Valid @RequestBody CreateProductRequest createProductRequest) {
        return ResponseEntity.ok(productService.create(createProductRequest));
    }

    @PutMapping
    public ResponseEntity<UpdateProductResponse> update(@Valid @RequestBody UpdateProductRequest updateProductRequest) {
        return ResponseEntity.ok(productService.update(updateProductRequest));
    }

    @DeleteMapping
    public ResponseEntity<DeleteProductResponse> delete(@Valid @RequestBody DeleteProductRequest deleteEmployeeRequest) {
        return ResponseEntity.ok(productService.delete(deleteEmployeeRequest));
    }
}
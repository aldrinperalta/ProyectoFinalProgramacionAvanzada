package edu.programacionavanzada.aperez.ProyectoFinal.controller;

import edu.programacionavanzada.aperez.ProyectoFinal.model.request.payment.CreatePaymentMethodRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.request.payment.DeletePaymentMethodRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.request.payment.UpdatePaymentMethodRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.payment.CreatePaymentMethodResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.payment.DeletePaymentMethodResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.payment.GetPaymentMethodResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.payment.UpdatePaymentMethodResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author aluis on 7/10/2022.
 */
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/payment/methods")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @GetMapping
    public ResponseEntity<GetPaymentMethodResponse> get(@RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                        @RequestParam(required = false, defaultValue = "0") Integer page) {
        return ResponseEntity.ok(paymentMethodService.getAll(pageSize, page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPaymentMethodResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(paymentMethodService.get(id));
    }

    @PostMapping
    public ResponseEntity<CreatePaymentMethodResponse> create(@Valid @RequestBody CreatePaymentMethodRequest createPaymentMethodRequest) {
        return ResponseEntity.ok(paymentMethodService.create(createPaymentMethodRequest));
    }

    @PutMapping
    public ResponseEntity<UpdatePaymentMethodResponse> update(@Valid @RequestBody UpdatePaymentMethodRequest updatePaymentMethodRequest) {
        return ResponseEntity.ok(paymentMethodService.update(updatePaymentMethodRequest));
    }

    @DeleteMapping
    public ResponseEntity<DeletePaymentMethodResponse> delete(@Valid @RequestBody DeletePaymentMethodRequest deleteEmployeeRequest) {
        return ResponseEntity.ok(paymentMethodService.delete(deleteEmployeeRequest));
    }
}
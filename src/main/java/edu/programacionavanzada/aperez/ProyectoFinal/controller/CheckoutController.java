package edu.programacionavanzada.aperez.ProyectoFinal.controller;

import edu.programacionavanzada.aperez.ProyectoFinal.model.request.checkout.CheckoutAddProductRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.request.checkout.CheckoutUpdateAddressRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.request.checkout.CheckoutUpdatePaymentMethodRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.request.checkout.PayCheckoutRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout.*;
import edu.programacionavanzada.aperez.ProyectoFinal.services.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @GetMapping
    public ResponseEntity<GetCheckoutResponse> get(@RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                   @RequestParam(required = false, defaultValue = "0") Integer page) {
        return ResponseEntity.ok(checkoutService.getAll(pageSize, page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCheckoutResponse> get(@PathVariable UUID id) {
        return ResponseEntity.ok(checkoutService.get(id));
    }

    @PostMapping("/update/address")
    public ResponseEntity<CheckoutUpdateAddressResponse> updateAddress(@Valid @RequestBody CheckoutUpdateAddressRequest checkoutUpdateAddressRequest) {
        return ResponseEntity.ok(checkoutService.updateAddress(checkoutUpdateAddressRequest));
    }

    @PostMapping("/update/payment/method")
    public ResponseEntity<CheckoutUpdatePaymentMethodResponse> updatePaymentMethod(@Valid @RequestBody CheckoutUpdatePaymentMethodRequest checkoutUpdatePaymentMethodRequest) {
        return ResponseEntity.ok(checkoutService.updatePaymentMethod(checkoutUpdatePaymentMethodRequest));
    }

    @PostMapping("/add/product")
    public ResponseEntity<CheckoutAddProductResponse> addProduct(@Valid @RequestBody CheckoutAddProductRequest checkoutAddProductRequest) {
        return ResponseEntity.ok(checkoutService.addProducts(checkoutAddProductRequest));
    }

    @PostMapping("/pay")
    public ResponseEntity<PayCheckoutResponse> pay(@Valid @RequestBody PayCheckoutRequest payCheckoutRequest) {
        return ResponseEntity.ok(checkoutService.pay(payCheckoutRequest));
    }
}

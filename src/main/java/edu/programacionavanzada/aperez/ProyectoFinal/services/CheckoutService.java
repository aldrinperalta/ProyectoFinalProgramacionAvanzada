package edu.programacionavanzada.aperez.ProyectoFinal.services;

import edu.programacionavanzada.aperez.ProyectoFinal.command.checkout.GetAllCheckoutCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.command.checkout.GetCheckoutCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.model.request.checkout.CheckoutAddProductRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.request.checkout.CheckoutUpdateAddressRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.request.checkout.CheckoutUpdatePaymentMethodRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.request.checkout.PayCheckoutRequest;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout.*;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CheckoutService {

    private final CommandBus commandBus;

    public GetCheckoutResponse getAll(Integer pageSize, Integer page) {
        return commandBus.sendCommand(GetAllCheckoutCommand.builder().pageSize(pageSize).page(page).build());
    }

    public GetCheckoutResponse get(UUID id) {
        return commandBus.sendCommand(GetCheckoutCommand.builder().id(id).build());
    }

    public CheckoutUpdatePaymentMethodResponse updatePaymentMethod(CheckoutUpdatePaymentMethodRequest checkoutUpdatePaymentMethodRequest) {
        return commandBus.sendCommand(checkoutUpdatePaymentMethodRequest.toCommand());
    }

    public CheckoutUpdateAddressResponse updateAddress(CheckoutUpdateAddressRequest checkoutUpdateAddressRequest) {
        return commandBus.sendCommand(checkoutUpdateAddressRequest.toCommand());
    }

    public CheckoutAddProductResponse addProducts(CheckoutAddProductRequest checkoutAddProductRequest) {
        return commandBus.sendCommand(checkoutAddProductRequest.toCommand());
    }

    public PayCheckoutResponse pay(PayCheckoutRequest payCheckoutRequest) {
        return commandBus.sendCommand(payCheckoutRequest.toCommand());
    }
}
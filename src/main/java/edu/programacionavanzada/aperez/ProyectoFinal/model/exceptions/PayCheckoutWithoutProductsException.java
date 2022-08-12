package edu.programacionavanzada.aperez.ProyectoFinal.model.exceptions;

import java.text.MessageFormat;
import java.util.UUID;


public class PayCheckoutWithoutProductsException extends RuntimeException {

    public PayCheckoutWithoutProductsException(UUID id) {
        super(MessageFormat.format("Checkout {0} doesnt have any product to buy", id));
    }
}
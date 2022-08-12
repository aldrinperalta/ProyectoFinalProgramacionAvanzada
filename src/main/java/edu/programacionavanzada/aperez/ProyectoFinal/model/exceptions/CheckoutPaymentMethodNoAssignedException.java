package edu.programacionavanzada.aperez.ProyectoFinal.model.exceptions;

import java.text.MessageFormat;
import java.util.UUID;


public class CheckoutPaymentMethodNoAssignedException extends RuntimeException {

    public CheckoutPaymentMethodNoAssignedException(UUID id) {
        super(MessageFormat.format("No payment method in checkout {0} ", id));
    }
}
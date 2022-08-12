package edu.programacionavanzada.aperez.ProyectoFinal.model.exceptions;

import java.text.MessageFormat;
import java.util.UUID;

public class CheckoutNoFoundException extends RuntimeException {

    public CheckoutNoFoundException(UUID id) {
        super(MessageFormat.format("Checkout {0} no found", id));
    }
}
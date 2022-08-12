package edu.programacionavanzada.aperez.ProyectoFinal.model.exceptions;

import java.text.MessageFormat;
import java.util.UUID;

public class OrderNoFoundException extends RuntimeException {

    public OrderNoFoundException(UUID id) {
        super(MessageFormat.format("Order {0} no found", id));
    }
}
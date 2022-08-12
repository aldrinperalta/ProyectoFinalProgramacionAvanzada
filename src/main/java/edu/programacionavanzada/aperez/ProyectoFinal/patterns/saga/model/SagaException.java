package edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model;

public class SagaException extends RuntimeException {

    public SagaException(Throwable cause) {
        super(cause);
    }
}
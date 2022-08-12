package edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model;

public interface SagaStepCompensator<T> {

    void handle(SagaPayload<T> sagaPayload);
}
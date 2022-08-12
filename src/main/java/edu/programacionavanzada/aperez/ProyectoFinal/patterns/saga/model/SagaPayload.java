package edu.programacionavanzada.aperez.ProyectoFinal.patterns.saga.model;

import edu.programacionavanzada.aperez.ProyectoFinal.domain.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class SagaPayload<T> {

    private final Map<SagaPayLoadKey<?>, Object> properties = new HashMap<>();
    @Getter
    @Setter
    private T result;

    public <M> M getProperty(SagaPayLoadKey<M> sagaPayLoadKey) {
        return sagaPayLoadKey.getType().cast(properties.get(sagaPayLoadKey));
    }

    public <M> void addProperty(SagaPayLoadKey<M> sagaPayLoadKey, M value) {
        properties.put(sagaPayLoadKey, value);
    }

    public <M> boolean hasProperty(SagaPayLoadKey<M> sagaPayLoadKey) {
        return properties.containsKey(sagaPayLoadKey);
    }

    public void addProperty(SagaPayLoadKey<Order> order, javax.persistence.criteria.Order order1) {
    }
}

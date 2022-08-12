package edu.programacionavanzada.aperez.ProyectoFinal.repositories;

import edu.programacionavanzada.aperez.ProyectoFinal.domain.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
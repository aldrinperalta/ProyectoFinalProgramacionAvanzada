package edu.programacionavanzada.aperez.ProyectoFinal.repositories;

import edu.programacionavanzada.aperez.ProyectoFinal.domain.CheckoutProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CheckoutProductRepository extends JpaRepository<CheckoutProduct, Long> {
}
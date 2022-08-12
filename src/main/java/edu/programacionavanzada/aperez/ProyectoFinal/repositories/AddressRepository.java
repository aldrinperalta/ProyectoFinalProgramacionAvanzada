package edu.programacionavanzada.aperez.ProyectoFinal.repositories;

import edu.programacionavanzada.aperez.ProyectoFinal.domain.Address;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
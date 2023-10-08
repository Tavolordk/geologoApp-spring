package org.nasa.spaceapp.geologoapp.repositories;

import org.nasa.spaceapp.geologoapp.entities.Prioridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrioridadRepository extends JpaRepository<Prioridad, Long> {
}


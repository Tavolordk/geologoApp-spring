package org.nasa.spaceapp.geologoapp.services;

import java.util.Optional;

import org.nasa.spaceapp.geologoapp.entities.Prioridad;

// PrioridadService.java
public interface PrioridadService {
    Prioridad createPrioridad(Prioridad prioridad);

    Optional<Prioridad> getPrioridadById(Long id);

    Optional<Prioridad> updatePrioridad(Long id, Prioridad prioridad);

    boolean deletePrioridad(Long id);
}

package org.nasa.spaceapp.geologoapp.serviceImpl;

import java.util.Optional;

import org.nasa.spaceapp.geologoapp.entities.Prioridad;
import org.nasa.spaceapp.geologoapp.repositories.PrioridadRepository;
import org.nasa.spaceapp.geologoapp.services.PrioridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// PrioridadServiceImpl.java
@Service
public class PrioridadServiceImpl implements PrioridadService {
    @Autowired
    private PrioridadRepository prioridadRepository;

    @Override
    public Prioridad createPrioridad(Prioridad prioridad) {
        return prioridadRepository.save(prioridad);
    }

    @Override
    public Optional<Prioridad> getPrioridadById(Long id) {
        return prioridadRepository.findById(id);
    }

    @Override
    public Optional<Prioridad> updatePrioridad(Long id, Prioridad updatedPrioridad) {
        return prioridadRepository.findById(id).map(existingPrioridad -> {
            existingPrioridad.setDescripcion(updatedPrioridad.getDescripcion());
            return prioridadRepository.save(existingPrioridad);
        });
    }

    @Override
    public boolean deletePrioridad(Long id) {
        if (prioridadRepository.existsById(id)) {
            prioridadRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

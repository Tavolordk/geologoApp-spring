package org.nasa.spaceapp.geologoapp.controllers;

import java.util.Optional;

import org.nasa.spaceapp.geologoapp.entities.Prioridad;
import org.nasa.spaceapp.geologoapp.services.PrioridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// PrioridadController.java
@RestController
@RequestMapping("/prioridad")
public class PrioridadController {
    @Autowired
    private PrioridadService prioridadService;

    @PostMapping
    public ResponseEntity<Prioridad> createPrioridad(@RequestBody Prioridad prioridad) {
        Prioridad createdPrioridad = prioridadService.createPrioridad(prioridad);
        return new ResponseEntity<>(createdPrioridad, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prioridad> getPrioridadById(@PathVariable Long id) {
        Optional<Prioridad> prioridad = prioridadService.getPrioridadById(id);
        return prioridad.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prioridad> updatePrioridad(@PathVariable Long id, @RequestBody Prioridad prioridad) {
        Optional<Prioridad> updatedPrioridad = prioridadService.updatePrioridad(id, prioridad);
        return updatedPrioridad.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrioridad(@PathVariable Long id) {
        if (prioridadService.deletePrioridad(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

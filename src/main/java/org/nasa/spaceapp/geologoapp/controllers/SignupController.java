package org.nasa.spaceapp.geologoapp.controllers;

import java.util.Optional;

import org.nasa.spaceapp.geologoapp.entities.Signup;
import org.nasa.spaceapp.geologoapp.services.SignupService;
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

// SignupController.java
@RestController
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    private SignupService signupService;

    @PostMapping
    public ResponseEntity<Signup> createSignup(@RequestBody Signup signup) {
        Signup createdSignup = signupService.createSignup(signup);
        return new ResponseEntity<>(createdSignup, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Signup> getSignupById(@PathVariable Long id) {
        Optional<Signup> signup = signupService.getSignupById(id);
        return signup.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Signup> updateSignup(@PathVariable Long id, @RequestBody Signup signup) {
        Optional<Signup> updatedSignup = signupService.updateSignup(id, signup);
        return updatedSignup.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSignup(@PathVariable Long id) {
        if (signupService.deleteSignup(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

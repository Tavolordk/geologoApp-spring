package org.nasa.spaceapp.geologoapp.services;

import java.util.Optional;

import org.nasa.spaceapp.geologoapp.entities.Signup;

// SignupService.java
public interface SignupService {
    Signup createSignup(Signup signup);

    Optional<Signup> getSignupById(Long id);

    Optional<Signup> updateSignup(Long id, Signup signup);

    boolean deleteSignup(Long id);
}

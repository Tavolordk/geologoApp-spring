package org.nasa.spaceapp.geologoapp.services;

import java.util.Optional;

import org.nasa.spaceapp.geologoapp.entities.Login;

// LoginService.java
public interface LoginService {
    Login createLogin(Login login);

    Optional<Login> getLoginById(Long id);

    Optional<Login> updateLogin(Long id, Login login);

    boolean deleteLogin(Long id);
}

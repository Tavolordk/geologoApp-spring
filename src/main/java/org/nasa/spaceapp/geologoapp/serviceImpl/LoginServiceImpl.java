package org.nasa.spaceapp.geologoapp.serviceImpl;

import java.util.Optional;

import org.nasa.spaceapp.geologoapp.entities.Login;
import org.nasa.spaceapp.geologoapp.repositories.LoginRepository;
import org.nasa.spaceapp.geologoapp.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// LoginServiceImpl.java
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login createLogin(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public Optional<Login> getLoginById(Long id) {
        return loginRepository.findById(id);
    }

    @Override
    public Optional<Login> updateLogin(Long id, Login updatedLogin) {
        return loginRepository.findById(id).map(existingLogin -> {
            existingLogin.setEmail(updatedLogin.getEmail());
            existingLogin.setPassword(updatedLogin.getPassword());
            return loginRepository.save(existingLogin);
        });
    }

    @Override
    public boolean deleteLogin(Long id) {
        if (loginRepository.existsById(id)) {
            loginRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

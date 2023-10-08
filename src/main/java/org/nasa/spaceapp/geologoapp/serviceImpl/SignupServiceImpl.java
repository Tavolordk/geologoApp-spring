package org.nasa.spaceapp.geologoapp.serviceImpl;

import java.util.Optional;

import org.nasa.spaceapp.geologoapp.entities.Signup;
import org.nasa.spaceapp.geologoapp.repositories.SignupRepository;
import org.nasa.spaceapp.geologoapp.services.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// SignupServiceImpl.java
@Service
public class SignupServiceImpl implements SignupService {
    @Autowired
    private SignupRepository signupRepository;

    @Override
    public Signup createSignup(Signup signup) {
        return signupRepository.save(signup);
    }

    @Override
    public Optional<Signup> getSignupById(Long id) {
        return signupRepository.findById(id);
    }

    @Override
    public Optional<Signup> updateSignup(Long id, Signup updatedSignup) {
        return signupRepository.findById(id).map(existingSignup -> {
            existingSignup.setNombre(updatedSignup.getNombre());
            existingSignup.setApellidoPaterno(updatedSignup.getApellidoPaterno());
            existingSignup.setApellidoMaterno(updatedSignup.getApellidoMaterno());
            existingSignup.setEmail(updatedSignup.getEmail());
            existingSignup.setPassword(updatedSignup.getPassword());
            return signupRepository.save(existingSignup);
        });
    }

    @Override
    public boolean deleteSignup(Long id) {
        if (signupRepository.existsById(id)) {
            signupRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

package org.nasa.spaceapp.geologoapp.serviceImpl;

import java.util.Optional;

import org.nasa.spaceapp.geologoapp.entities.ProfileUser;
import org.nasa.spaceapp.geologoapp.repositories.ProfileUserRepository;
import org.nasa.spaceapp.geologoapp.services.ProfileUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// ProfileUserServiceImpl.java
@Service
public class ProfileUserServiceImpl implements ProfileUserService {
    @Autowired
    private ProfileUserRepository profileUserRepository;

    @Override
    public ProfileUser createProfileUser(ProfileUser profileUser) {
        return profileUserRepository.save(profileUser);
    }

    @Override
    public Optional<ProfileUser> getProfileUserById(Long id) {
        return profileUserRepository.findById(id);
    }

    @Override
    public Optional<ProfileUser> updateProfileUser(Long id, ProfileUser updatedProfileUser) {
        return profileUserRepository.findById(id).map(existingProfileUser -> {
            existingProfileUser.setSignup(updatedProfileUser.getSignup());
            existingProfileUser.setFotoPerfil(updatedProfileUser.getFotoPerfil());
            existingProfileUser.setDescripcion(updatedProfileUser.getDescripcion());
            return profileUserRepository.save(existingProfileUser);
        });
    }

    @Override
    public boolean deleteProfileUser(Long id) {
        if (profileUserRepository.existsById(id)) {
            profileUserRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

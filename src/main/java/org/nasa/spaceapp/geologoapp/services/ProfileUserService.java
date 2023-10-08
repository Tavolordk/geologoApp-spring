package org.nasa.spaceapp.geologoapp.services;

import java.util.Optional;

import org.nasa.spaceapp.geologoapp.entities.ProfileUser;

// ProfileUserService.java
public interface ProfileUserService {
    ProfileUser createProfileUser(ProfileUser profileUser);

    Optional<ProfileUser> getProfileUserById(Long id);

    Optional<ProfileUser> updateProfileUser(Long id, ProfileUser profileUser);

    boolean deleteProfileUser(Long id);
}


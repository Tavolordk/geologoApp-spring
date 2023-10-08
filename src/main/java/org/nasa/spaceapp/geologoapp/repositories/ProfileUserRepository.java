package org.nasa.spaceapp.geologoapp.repositories;

import org.nasa.spaceapp.geologoapp.entities.ProfileUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileUserRepository extends JpaRepository<ProfileUser, Long> {
}
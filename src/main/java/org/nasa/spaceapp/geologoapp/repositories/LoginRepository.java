package org.nasa.spaceapp.geologoapp.repositories;

import java.util.Optional;

import org.nasa.spaceapp.geologoapp.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> findByEmail(String email);
}
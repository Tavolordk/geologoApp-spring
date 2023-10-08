package org.nasa.spaceapp.geologoapp.repositories;

import java.util.Optional;

import org.nasa.spaceapp.geologoapp.entities.Signup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupRepository extends JpaRepository<Signup, Long> {
    Optional<Signup> findByEmail(String email);
}
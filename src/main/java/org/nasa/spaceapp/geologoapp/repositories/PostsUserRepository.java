package org.nasa.spaceapp.geologoapp.repositories;

import java.util.List;

import org.nasa.spaceapp.geologoapp.entities.PostsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsUserRepository extends JpaRepository<PostsUser, Long> {
    @Query("SELECT p FROM PostsUser p WHERE p.profileUser.id  = :profileUserId")
    List<PostsUser> findByProfileUserId(@Param("profileUserId") Long profileUserId);
}
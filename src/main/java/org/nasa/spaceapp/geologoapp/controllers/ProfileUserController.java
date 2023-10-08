package org.nasa.spaceapp.geologoapp.controllers;

import java.util.Optional;

import org.nasa.spaceapp.geologoapp.entities.ProfileUser;
import org.nasa.spaceapp.geologoapp.services.ProfileUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ProfileUserController.java
@RestController
@RequestMapping("/profileUser")
public class ProfileUserController {
    @Autowired
    private ProfileUserService profileUserService;

    @PostMapping
    public ResponseEntity<ProfileUser> createProfileUser(@RequestBody ProfileUser profileUser) {
        ProfileUser createdProfileUser = profileUserService.createProfileUser(profileUser);
        return new ResponseEntity<>(createdProfileUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileUser> getProfileUserById(@PathVariable Long id) {
        Optional<ProfileUser> profileUser = profileUserService.getProfileUserById(id);
        return profileUser.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileUser> updateProfileUser(@PathVariable Long id, @RequestBody ProfileUser profileUser) {
        Optional<ProfileUser> updatedProfileUser = profileUserService.updateProfileUser(id, profileUser);
        return updatedProfileUser.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfileUser(@PathVariable Long id) {
        if (profileUserService.deleteProfileUser(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


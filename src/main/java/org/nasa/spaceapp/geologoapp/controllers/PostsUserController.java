package org.nasa.spaceapp.geologoapp.controllers;

import java.util.List;
import java.util.Optional;

import org.nasa.spaceapp.geologoapp.entities.PostsUser;
import org.nasa.spaceapp.geologoapp.services.PostsUserService;
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

// PostsUserController.java
@RestController
@RequestMapping("/postsUser")
public class PostsUserController {
    @Autowired
    private PostsUserService postsUserService;

    @PostMapping
    public ResponseEntity<PostsUser> createPostsUser(@RequestBody PostsUser postsUser) {
        PostsUser createdPostsUser = postsUserService.createPostsUser(postsUser);
        return new ResponseEntity<>(createdPostsUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostsUser> getPostsUserById(@PathVariable Long id) {
        Optional<PostsUser> postsUser = postsUserService.getPostsUserById(id);
        return postsUser.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/byProfileUserId/{profileUserId}")
    public List<PostsUser> getPostsByProfileUserId(@PathVariable Long profileUserId) {
        return postsUserService.getPostsByProfileUserId(profileUserId);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PostsUser> updatePostsUser(@PathVariable Long id, @RequestBody PostsUser postsUser) {
        Optional<PostsUser> updatedPostsUser = postsUserService.updatePostsUser(id, postsUser);
        return updatedPostsUser.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostsUser(@PathVariable Long id) {
        if (postsUserService.deletePostsUser(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

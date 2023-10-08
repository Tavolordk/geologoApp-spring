package org.nasa.spaceapp.geologoapp.services;

import java.util.List;
import java.util.Optional;

import org.nasa.spaceapp.geologoapp.entities.PostsUser;

// PostsUserService.java
public interface PostsUserService {
    PostsUser createPostsUser(PostsUser postsUser);

    Optional<PostsUser> getPostsUserById(Long id);

    Optional<PostsUser> updatePostsUser(Long id, PostsUser postsUser);
    List<PostsUser> getPostsByProfileUserId(Long profileUserId);

    boolean deletePostsUser(Long id);
}


package org.nasa.spaceapp.geologoapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.nasa.spaceapp.geologoapp.entities.PostsUser;
import org.nasa.spaceapp.geologoapp.repositories.PostsUserRepository;
import org.nasa.spaceapp.geologoapp.services.PostsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// PostsUserServiceImpl.java
@Service
public class PostsUserServiceImpl implements PostsUserService {
    @Autowired
    private PostsUserRepository postsUserRepository;

    @Override
    public PostsUser createPostsUser(PostsUser postsUser) {
        return postsUserRepository.save(postsUser);
    }

    @Override
    public Optional<PostsUser> getPostsUserById(Long id) {
        return postsUserRepository.findById(id);
    }

    @Override
    public Optional<PostsUser> updatePostsUser(Long id, PostsUser updatedPostsUser) {
        return postsUserRepository.findById(id).map(existingPostsUser -> {
            existingPostsUser.setTema(updatedPostsUser.getTema());
            existingPostsUser.setSubtema(updatedPostsUser.getSubtema());
            existingPostsUser.setPrioridad(updatedPostsUser.getPrioridad());
            existingPostsUser.setImagen(updatedPostsUser.getImagen());
            existingPostsUser.setDescripcion(updatedPostsUser.getDescripcion());
            return postsUserRepository.save(existingPostsUser);
        });
    }

    @Override
    public boolean deletePostsUser(Long id) {
        if (postsUserRepository.existsById(id)) {
            postsUserRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<PostsUser> getPostsByProfileUserId(Long profileUserId) {
        return postsUserRepository.findByProfileUserId(profileUserId);
    }
}

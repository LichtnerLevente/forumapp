package com.example.forumapp.service;

import com.example.forumapp.model.entities.Post;
import com.example.forumapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostByID(Long postId) {
        return postRepository.getReferenceById(postId);
    }

    public Post createNewPost(Post post) {
        return postRepository.save(post);
    }

    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }

    public Post editPost(Post editedPost, Long postId) {

        return postRepository.findById(postId).map(post -> {
                    post.setTitle(editedPost.getTitle());
                    post.setDescription(editedPost.getDescription());
                    return postRepository.save(post);
                })

                .orElseThrow();
    }
}
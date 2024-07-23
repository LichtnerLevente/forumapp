package com.example.forumapp.service;

import com.example.forumapp.model.DTO.NewPostDTO;
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

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post getPostByID(Long postId) {
        return postRepository.getReferenceById(postId);
    }

    public boolean createNewPost(NewPostDTO post) {
        //return postRepository.save(post);
        return true;
    }

    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }
}
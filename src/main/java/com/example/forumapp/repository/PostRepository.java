package com.example.forumapp.repository;

import com.example.forumapp.model.DTO.NewPostDTO;
import com.example.forumapp.model.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PostRepository extends JpaRepository<Post, Long>{
    Post editPost(Post post, Long postId);
    Post savePost(NewPostDTO post);

}

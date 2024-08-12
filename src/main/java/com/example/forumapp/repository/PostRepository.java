package com.example.forumapp.repository;

import com.example.forumapp.model.DTO.NewPostDTO;
import com.example.forumapp.model.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long>{
}

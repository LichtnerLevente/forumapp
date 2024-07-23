package com.example.forumapp.controller;

import com.example.forumapp.model.DTO.NewPostDTO;
import com.example.forumapp.model.entities.Comment;
import com.example.forumapp.model.entities.Post;
import com.example.forumapp.repository.PostRepository;
import com.example.forumapp.service.CommentService;
import com.example.forumapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("./api/")
public class Controller {

    private final PostService postService;
    private final CommentService commentService;
    private final PostRepository postRepository;

    @Autowired
    public Controller(PostService postService, CommentService commentService, PostRepository postRepository) {
        this.postService = postService;
        this.commentService = commentService;
        this.postRepository = postRepository;
    }


    //get all
    @GetMapping("./posts/all")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    //get post
    @GetMapping("./posts/{post_id}")
    public Post getPostById(@PathVariable Long post_id) {
        return postService.getPostByID(post_id);
    }

    //get comments
    @GetMapping("./comments/{post_id}")
    public List<Comment> getCommentsByPost(@PathVariable Long post_id) {
        return commentService.getCommentsByPostId(post_id);
    }

    //create post/comment
    @GetMapping("./posts/create")
    public boolean createPost(NewPostDTO post) {
        return postService.createNewPost(post);
    }

    //delete post/comment
    @GetMapping("./post/delete/{post_id}")
    public void deletePost(@PathVariable Long post_id) {
        postService.deletePostById(post_id);
    }

    @GetMapping("./posts/edit/{post_id}")
    public Post editPost(@RequestBody Post post, @PathVariable Long post_id) {
        return postRepository.editPost(post, post_id);
    }

}

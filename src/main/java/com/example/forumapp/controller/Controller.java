package com.example.forumapp.controller;

import com.example.forumapp.model.DTO.NewCommentDTO;
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


    @GetMapping("./posts/all")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("./posts/{post_id}")
    public Post getPostById(@PathVariable Long post_id) {
        return postService.getPostByID(post_id);
    }

    @PostMapping("./posts/create")
    public void createPost(NewPostDTO post) {
        postService.createNewPost(post);
    }

    @DeleteMapping("./post/{post_id}")
    public void deletePost(@PathVariable Long post_id) {
        postService.deletePostById(post_id);
    }

    @PutMapping("./posts/{post_id}")
    public Post editPost(@RequestBody Post post, @PathVariable Long post_id) {
        return postService.editPost(post, post_id);
    }

    @GetMapping("./comments/{comment_id}")
    public Comment getCommentById(@PathVariable Long comment_id){
        return commentService.getCommentById(comment_id);
    }

    @GetMapping("./comments/{post_id}")
    public List<Comment> getCommentsByPost(@PathVariable Long post_id) {
        return commentService.getCommentsByPostId(post_id);
    }
    @PostMapping("./comments/create")
    public void createComment(NewCommentDTO comment) {
        commentService.createComment(comment);
    }

    @DeleteMapping("./comments/{comment_id}")
    public void deleteComment(@PathVariable Long comment_id) {
        commentService.deleteCommentById(comment_id);
    }

    @PutMapping("./comments/{comment_id}")
    public Comment editComment(@RequestBody Comment comment, @PathVariable Long comment_id) {
        return commentService.editComment(comment, comment_id);
    }



    @GetMapping("./users/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("./users/{user_id}")
    public User getUserById(@PathVariable Long user_id) {
        return userService.getUserById(user_id);
    }

    @PostMapping("./users/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("./users/{user_id}")
    public void deleteUser(@PathVariable Long user_id) {
        userService.deleteUserById(user_id);
    }

}

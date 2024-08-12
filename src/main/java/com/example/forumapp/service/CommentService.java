package com.example.forumapp.service;

import com.example.forumapp.model.entities.Comment;
import com.example.forumapp.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment getCommentById(long id) {
        return commentRepository.findById(id).get();
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return null;
    }

    public void deleteCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public Comment editComment(Comment editedComment, Long commentId) {
        return commentRepository.findById(commentId).map(comment -> {
                    comment.setText(editedComment.getText());
                    return commentRepository.save(comment);
                })
                .orElseThrow();
    }
}

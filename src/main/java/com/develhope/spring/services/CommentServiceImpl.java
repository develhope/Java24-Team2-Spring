package com.develhope.spring.services;

import com.develhope.spring.entities.Comment;
import com.develhope.spring.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment getCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElseThrow(()->new NoSuchElementException("Comment not found"));
    }

    @Override
    public Comment createComment(Comment comment) {
        Optional<Comment> optionalComment = commentRepository.findById(comment.getId());
        if(optionalComment.isPresent()){
            throw new IllegalArgumentException("Comment already exist");
        }
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public Comment updateComment(Comment comment, Long id) {
        Optional <Comment> optionalComment= commentRepository.findById(id);
        if(optionalComment.isPresent()){
            Comment existComment = optionalComment.get();
            existComment.setText(comment.getText());
            existComment.setDateTime((comment.getDateTime()));
            return commentRepository.saveAndFlush(existComment);
        }else{
            throw new NoSuchElementException("Comment not found");
        }
    }

    @Override
    public void deleteCommentById(Long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if(optionalComment.isPresent()){
            commentRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Comment not found");
        }

    }
}

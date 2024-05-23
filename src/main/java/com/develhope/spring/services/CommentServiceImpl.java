package com.develhope.spring.services;

import com.develhope.spring.entities.Comment;
import com.develhope.spring.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElse(null);
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public Comment updateComment(Comment comment, Long id) throws Exception {
        Optional <Comment> optionalComment= commentRepository.findById(id);
        if(optionalComment.isPresent()){
            Comment existComment = optionalComment.get();
            existComment.setText(comment.getText());
            existComment.setDateTime((comment.getDateTime()));
            return commentRepository.saveAndFlush(existComment);
        }else{
            throw new Exception();
        }
    }

    @Override
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void deleteAllComment() {
        commentRepository.deleteAll();
    }
}

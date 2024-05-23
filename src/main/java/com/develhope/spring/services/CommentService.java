package com.develhope.spring.services;

import com.develhope.spring.entities.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    public List<Comment> getAllComment();

    public Comment getCommentById(Long id);

    public Comment createComment(Comment comment);

    public Comment updateComment (Comment comment, Long id) throws Exception;

    public void deleteCommentById(Long id);

    public void deleteAllComment();
}

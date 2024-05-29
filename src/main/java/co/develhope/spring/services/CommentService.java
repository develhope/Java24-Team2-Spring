package co.develhope.spring.services;

import co.develhope.spring.entities.Comment;


public interface CommentService {

    public Comment getCommentById(Long id);

    public Comment createComment(Comment comment);

    public Comment updateComment (Comment comment, Long id);

    public void deleteCommentById(Long id);
}

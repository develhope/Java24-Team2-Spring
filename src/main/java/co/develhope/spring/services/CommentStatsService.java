package co.develhope.spring.services;

import co.develhope.spring.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentStatsService {

    @Autowired
    CommentRepository commentRepository;

    public int countTotalComment() {
        return commentRepository.countTotalComments();
    }

    public double averageCommentText() {
        return commentRepository.averageCommentLength();
    }

    public List<Object[]> countCommentForUser() {
        return commentRepository.countCommentForUsers();
    }

    public List<Object[]> countCommentForArticle() {
        return commentRepository.countCommentForArticle();
    }
}

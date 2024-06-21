package co.develhope.spring.services;

import co.develhope.spring.entities.Article;
import co.develhope.spring.entities.Comment;
import co.develhope.spring.entities.User;
import co.develhope.spring.repositories.ArticleRepository;
import co.develhope.spring.repositories.CommentRepository;
import co.develhope.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Comment getCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElseThrow(()->new NoSuchElementException("Comment not found"));
    }

    @Override
    public Comment createComment(Comment comment) {
        User user = userRepository.findById(comment.getUser().getId())
                        .orElseThrow(() -> new RuntimeException("User not found"));

        Article article = articleRepository.findById(comment.getArticle().getId())
                        .orElseThrow(() -> new RuntimeException("Article not found"));

        comment.setUser(user);
        comment.setArticle(article);
        comment.setDateTime(new Date());

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

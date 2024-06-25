package co.develhope.spring.services;

import co.develhope.spring.dtoconverters.LikeMapper;
import co.develhope.spring.dtos.LikeDto;
import co.develhope.spring.entities.Comment;
import co.develhope.spring.entities.Like;
import co.develhope.spring.entities.User;
import co.develhope.spring.exceptions.UserNotFoundException;
import co.develhope.spring.repositories.CommentRepository;
import co.develhope.spring.repositories.LikeRepository;
import co.develhope.spring.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private LikeMapper likeMapper;

    public Like likeComment(Long userId, Long commentId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("Comment not found"));

        Like like = new Like();
        like.setUser(user);
        like.setComment(comment);
        like.setDateTime(LocalDateTime.now());

        return likeRepository.save(like);
    }

    public void unLikeComment(Long userId, Long commentId) throws Throwable {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new EntityNotFoundException("Follow id not found"));
        likeRepository.deleteById(commentId);
    }

    public List<Like> getLikesByUser(Long userId) {
        return likeRepository.findByUserId(userId);
    }

    public List<LikeDto> getLikesByComment(Long commentId) {
        List<Like> likes = likeRepository.findByCommentId(commentId);
        return likes.stream().map(likeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public long countLikesByComment(Long commentId) {
        return likeRepository.findByCommentId(commentId).size();
    }

    public long countLikesByUser(Long userId) {
        return likeRepository.findByUserId(userId).size();
    }
}


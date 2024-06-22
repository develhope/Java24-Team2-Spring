package co.develhope.spring.services;

import co.develhope.spring.dtoconverters.LikeMapper;
import co.develhope.spring.dtos.LikeDto;
import co.develhope.spring.entities.Comment;
import co.develhope.spring.entities.ILike;
import co.develhope.spring.entities.User;
import co.develhope.spring.exceptions.UserNotFoundException;
import co.develhope.spring.repositories.CommentRepository;
import co.develhope.spring.repositories.ILikeRepository;
import co.develhope.spring.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ILikeService {

    @Autowired
    private ILikeRepository iLikeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private LikeMapper likeMapper;

    public ILike likeComment(Long userId, Long commentId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("Comment not found"));

        ILike iLike = new ILike();
        iLike.setUser(user);
        iLike.setComment(comment);
        iLike.setDateTime(LocalDateTime.now());

        return iLikeRepository.save(iLike);
    }

    public void unLikeComment(Long userId, Long commentId) throws Throwable {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new EntityNotFoundException("Follow id not found"));
        iLikeRepository.deleteById(commentId);
    }

    public List<ILike> getLikesByUser(Long userId) {
        return iLikeRepository.findByUserId(userId);
    }

    public List<LikeDto> getLikesByComment(Long commentId) {
        List<ILike> likes = iLikeRepository.findByCommentId(commentId);
        return likes.stream().map(likeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public long countLikesByComment(Long commentId) {
        return iLikeRepository.findByCommentId(commentId).size();
    }

    public long countLikesByUser(Long userId) {
        return iLikeRepository.findByUserId(userId).size();
    }
}


package co.develhope.spring.services;

import co.develhope.spring.entities.ILike;
import co.develhope.spring.repositories.ILikeRepository;
import co.develhope.spring.entities.Comment;
import co.develhope.spring.entities.User;
import co.develhope.spring.repositories.CommentRepository;
import co.develhope.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ILikeService {

    @Autowired
    private ILikeRepository iLikeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    public ILike likeComment(Long userId, Long commentId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("Comment not found"));

        ILike iLike = new ILike();
        iLike.setUser(user);
        iLike.setComment(comment);
        iLike.setDateTime(LocalDateTime.now());

        return iLikeRepository.save(iLike);
    }

    public List<ILike> getLikesByUser(Long userId) {
        return iLikeRepository.findByUserId(userId);
    }

    public List<ILike> getLikesByComment(Long commentId) {
        return iLikeRepository.findByCommentId(commentId);
    }

    public long countLikesByComment(Long commentId) {
        return iLikeRepository.findByCommentId(commentId).size();
    }

    public long countLikesByUser(Long userId) {
        return iLikeRepository.findByUserId(userId).size();
    }
}


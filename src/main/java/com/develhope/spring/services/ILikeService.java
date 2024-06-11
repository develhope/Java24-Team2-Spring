package com.develhope.spring.services;

import com.develhope.spring.entities.Comment;
import com.develhope.spring.entities.ILike;
import com.develhope.spring.entities.User;
import com.develhope.spring.repositories.CommentRepository;
import com.develhope.spring.repositories.ILikeRepository;
import com.develhope.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class ILikeService {

    @Autowired
    private ILikeRepository iLikeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    public ILike likeComment(Long userId, Long commentId) throws Throwable {
        User user = (User) userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("Comment not found"));

        ILike iLike = new ILike();
        iLike.setUser(user);
        ILike.setComment(comment);
        ILike.setDateTime(LocalDateTime.now());

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


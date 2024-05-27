package com.develhope.spring.repositories;

import com.develhope.spring.entities.ILike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILikeRepository extends JpaRepository<ILike, Long> {
    List<ILike> findByUserId(Long userId);
    List<ILike> findByCommentId(Long commentId);
}

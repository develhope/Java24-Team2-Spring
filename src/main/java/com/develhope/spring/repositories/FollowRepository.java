package com.develhope.spring.repositories;

import com.develhope.spring.entities.Follow;
import com.develhope.spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findByFollower(User follower);
    List<Follow> findByFollowed(User followed);
    Follow findByFollowerAndFollowed(User follower, User followed);
}
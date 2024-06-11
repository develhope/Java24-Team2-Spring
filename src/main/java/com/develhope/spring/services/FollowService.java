package com.develhope.spring.services;

import com.develhope.spring.entities.Follow;
import com.develhope.spring.entities.User;
import com.develhope.spring.repositories.FollowRepository;
import com.develhope.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserRepository userRepository;

    public Follow followUser(Long followerId, Long followedId) throws Throwable {
        User follower = (User) userRepository.findById(followerId).orElseThrow(() -> new IllegalArgumentException("Follower not found"));
        User followed = (User) userRepository.findById(followedId).orElseThrow(() -> new IllegalArgumentException("Followed user not found"));

        if (followRepository.findByFollowerAndFollowed(follower, followed) != null) {
            throw new IllegalArgumentException("Already following this user");
        }

        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setFollowed(followed);
        follow.setDataOra(LocalDateTime.now());

        return followRepository.save(follow);
    }

    public void unfollowUser(Long followerId, Long followedId) throws Throwable {
        User follower = (User) userRepository.findById(followerId).orElseThrow(() -> new IllegalArgumentException("Follower not found"));
        User followed = (User) userRepository.findById(followedId).orElseThrow(() -> new IllegalArgumentException("Followed user not found"));

        Follow follow = followRepository.findByFollowerAndFollowed(follower, followed);
        if (follow != null) {
            followRepository.delete(follow);
        } else {
            throw new IllegalArgumentException("Not following this user");
        }
    }

    public List<Follow> getFollowing(Long userId) throws Throwable {
        User user = (User) userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return followRepository.findByFollower(user);
    }

    public List<Follow> getFollowers(Long userId) throws Throwable {
        User user = (User) userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return followRepository.findByFollowed(user);
    }
}

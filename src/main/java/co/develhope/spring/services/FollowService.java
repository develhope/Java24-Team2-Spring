package co.develhope.spring.services;

import co.develhope.spring.entities.Follow;
import co.develhope.spring.entities.User;
import co.develhope.spring.exceptions.UserNotFoundException;
import co.develhope.spring.repositories.FollowRepository;
import co.develhope.spring.repositories.UserRepository;
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

    public Follow followUser(Long followerId, Long userId) throws Throwable {
        User follower = userRepository.findById(followerId).orElseThrow(() -> new IllegalArgumentException("Follower not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Followed user not found"));

        if (followRepository.existsByFollowerIdAndUserId(followerId, userId)) {
            throw new IllegalArgumentException("Already following this user");
        }

        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setUser(user);
        follow.setDataOra(LocalDateTime.now());

        return followRepository.save(follow);
    }

    public void unfollowUser(Long followerId, Long userId) throws Throwable {
        User follower = userRepository.findById(followerId).orElseThrow(() -> new IllegalArgumentException("Follower not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Followed user not found"));

        Follow follow = followRepository.findByFollowerAndUser(follower, user);
        if (follow != null) {
            followRepository.delete(follow);
        } else {
            throw new IllegalArgumentException("Not following this user");
        }
    }

    public List<Follow> getFollowing(Long userId) throws Throwable {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return followRepository.findByFollower(user);
    }
}

// Aggiornati i metodi followUser, unfollowUser e getFollowing per riflettere le modifiche nell'entità.

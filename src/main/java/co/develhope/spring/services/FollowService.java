package co.develhope.spring.services;

import co.develhope.spring.dtoconverters.FollowMapper;
import co.develhope.spring.dtos.FollowDto;
import co.develhope.spring.dtos.UserDto;
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

    @Autowired
    private FollowMapper followMapper;

    public FollowDto followUser(FollowDto followDto) throws Throwable {

        User follower = userRepository.findById(followDto.getFollower().getId()).orElseThrow(() -> new IllegalArgumentException("Follower not found"));
        Follow followed = followMapper.toEntity(followDto);
        User user= userRepository.findById(followed.getUser().getId()).orElseThrow(() -> new UserNotFoundException("User not found"));

        if (followRepository.existsByFollowerIdAndUserId(follower.getId(), user.getId())) {
            throw new IllegalArgumentException("Already following this user");
        }


        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setUser(user);
        follow.setDataOra(LocalDateTime.now());

        followRepository.save(follow);
        return followMapper.toDTO(follow);
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

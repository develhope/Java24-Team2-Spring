package co.develhope.spring.services;

import co.develhope.spring.dtoconverters.FollowMapper;
import co.develhope.spring.dtos.FollowDto;
import co.develhope.spring.entities.Follow;
import co.develhope.spring.entities.User;
import co.develhope.spring.exceptions.UserNotFoundException;
import co.develhope.spring.repositories.FollowRepository;
import co.develhope.spring.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FollowMapper followMapper;

    public FollowDto followUser(FollowDto followDto) throws Throwable {
        User follower = userRepository.findById(followDto.getFollowerId()).orElseThrow(() -> new UserNotFoundException("Follower not found"));
        User user = userRepository.findById(followDto.getUserId()).orElseThrow(() -> new UserNotFoundException("User not found"));

        if (followRepository.existsByFollowerIdAndUserId(follower.getId(), user.getId())) {
            throw new IllegalArgumentException("Already following this user");
        }
        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setUser(user);
        follow.setDate(LocalDateTime.now());

        followRepository.save(follow);
        return followMapper.toDTO(follow);
    }

    public void unfollowUser(Long userId, Long followId) throws Throwable {
        userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found"));
        followRepository.findById(followId).orElseThrow(() -> new EntityNotFoundException("Follow id not found"));
        followRepository.deleteById(followId);
    }

    public List<Long> getFollowers(Long userId) throws Throwable {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        List<Follow> follows = followRepository.findAllByUser(user);
        return follows.stream()
                .map(Follow::getFollower)
                .map(User::getId) // Prendi solo l'ID del follower
                .collect(Collectors.toList());
    }

    public List<Long> getFollowed(Long userId) throws Throwable {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        List<Follow> follows = followRepository.findAllByFollower(user);
        return follows.stream()
                .map(Follow::getUser)
                .map(User::getId) // Prendi solo l'ID del followed
                .collect(Collectors.toList());
    }

    public Long getNumberOfFollows(Long userId){
        User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User Not Found"));
        return followRepository.countFollowersByUserId(user.getId());
    }

    public Long getNumberOfFollowed(Long userId){
        User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User Not Found"));
        return followRepository.countFollowingByFollowerId(user.getId());
    }
}


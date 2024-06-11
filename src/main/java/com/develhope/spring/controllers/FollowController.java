package com.develhope.spring.controllers;

import com.develhope.spring.entities.Follow;
import com.develhope.spring.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/follow")
    public Follow followUser(@RequestParam Long followerId, @RequestParam Long followedId) throws Throwable {
        return followService.followUser(followerId, followedId);
    }

    @DeleteMapping("/unfollow")
    public void unfollowUser(@RequestParam Long followerId, @RequestParam Long followedId) throws Throwable {
        followService.unfollowUser(followerId, followedId);
    }

    @GetMapping("/following/{userId}")
    public List<Follow> getFollowing(@PathVariable Long userId) throws Throwable {
        return followService.getFollowing(userId);
    }

    @GetMapping("/followers/{userId}")
    public List<Follow> getFollowers(@PathVariable Long userId) throws Throwable {
        return followService.getFollowers(userId);
    }
}

package co.develhope.spring.controllers;

import co.develhope.spring.entities.Follow;
import co.develhope.spring.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/follow")
    public Follow followUser(@RequestParam Long followerId, @RequestParam Long userId) throws Throwable {
        return followService.followUser(followerId, userId);
    }

    @DeleteMapping("/unfollow")
    public void unfollowUser(@RequestParam Long followerId, @RequestParam Long userId) throws Throwable {
        followService.unfollowUser(followerId, userId);
    }

    @GetMapping("/following/{userId}")
    public List<Follow> getFollowing(@PathVariable Long userId) throws Throwable {
        return followService.getFollowing(userId);
    }
}

// Aggiornati i parametri degli endpoint per utilizzare userId invece di followedId.
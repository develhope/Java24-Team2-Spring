package co.develhope.spring.controllers;

import co.develhope.spring.dtos.FollowDto;
import co.develhope.spring.dtos.UserDto;
import co.develhope.spring.entities.Follow;
import co.develhope.spring.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping
    public FollowDto followUser(@RequestBody FollowDto followDto, @RequestBody UserDto userDto) throws Throwable {
        return followService.followUser(followDto, userDto);
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
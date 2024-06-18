package co.develhope.spring.controllers;

import co.develhope.spring.dtos.FollowDto;
import co.develhope.spring.dtos.UserDto;
import co.develhope.spring.entities.Follow;
import co.develhope.spring.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/follow")
    public ResponseEntity<?> followUser(@RequestBody FollowDto followDto) throws Throwable {
        return ResponseEntity.ok(followService.followUser(followDto));
    }

    @DeleteMapping("/unfollow/{id}")
    public ResponseEntity<String> unfollowUser(@PathVariable Long id) throws Throwable {
        followService.unfollowUser(id);
        return ResponseEntity.ok("User unfollowed");
    }

    @GetMapping("/following/{userId}")
    public List<Follow> getFollowing(@PathVariable Long userId) throws Throwable {
        return followService.getFollowing(userId);
    }
}

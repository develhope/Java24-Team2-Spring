package co.develhope.spring.controllers;

import co.develhope.spring.dtos.FollowDto;
import co.develhope.spring.entities.Follow;
import co.develhope.spring.exceptions.UserNotFoundException;
import co.develhope.spring.services.FollowService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/follow")
    public ResponseEntity<FollowDto> followUser(@RequestBody FollowDto followDto) throws Throwable {
        return ResponseEntity.ok(followService.followUser(followDto));
    }

    @GetMapping("/following/{userId}")
    public ResponseEntity<List<Follow>> getFollowing(@PathVariable Long userId) throws Throwable {
        return ResponseEntity.ok(followService.getFollowing(userId));
    }

    @GetMapping("/number-of-follower/{userId}")
    public ResponseEntity<?> getNumberOfFollower(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(followService.getNumberOfFollows(userId));
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/number-of-followed/{userId}")
    public ResponseEntity<?> getNumberOfFollowed(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(followService.getNumberOfFollowed(userId));
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/unfollow/{userId}/follow/{followId}")
    public ResponseEntity<String> unfollowUser(@PathVariable Long userId, @PathVariable Long followId) {
        try {
            followService.unfollowUser(userId, followId);
            return ResponseEntity.ok("Successfully unfollowed user");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Throwable e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while unfollowing user");
        }
    }
}

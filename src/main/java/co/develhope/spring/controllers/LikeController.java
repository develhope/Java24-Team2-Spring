package co.develhope.spring.controllers;

import co.develhope.spring.dtos.LikeDto;
import co.develhope.spring.entities.Like;
import co.develhope.spring.services.LikeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/{userId}")
    public Like likeComment(@PathVariable Long userId, @RequestParam Long commentId) throws Throwable {
        return likeService.likeComment(userId, commentId);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<List<LikeDto>> getLikesByComment(@PathVariable Long commentId) {
        return ResponseEntity.ok(likeService.getLikesByComment(commentId));
    }

    @GetMapping("/count/user/{userId}")
    public long countLikesByUser(@PathVariable Long userId) {
        return likeService.countLikesByUser(userId);
    }

    @GetMapping("/count/comment/{commentId}")
    public long countLikesByComment(@PathVariable Long commentId) {
        return likeService.countLikesByComment(commentId);
    }

    @DeleteMapping("/unlike/{userId}/{commentId}")
    public ResponseEntity<String> unLikeComment(@PathVariable Long userId, @PathVariable Long commentId) {
        try {
            likeService.unLikeComment(userId, commentId);
            return ResponseEntity.ok("Successfully unliked user's comment");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Throwable e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while unfollowing user's comment");
        }
    }
}
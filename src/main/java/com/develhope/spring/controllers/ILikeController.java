package com.develhope.spring.controllers;

import com.develhope.spring.entities.ILike;
import com.develhope.spring.services.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class ILikeController {

    @Autowired
    private ILikeService iLikeService;

    @PostMapping("/like")
    public ILike likeComment(@RequestParam Long userId, @RequestParam Long commentId) throws Throwable {
        return iLikeService.likeComment(userId, commentId);
    }

    @GetMapping("/user/{userId}")
    public List<ILike> getLikesByUser(@PathVariable Long userId) {
        return iLikeService.getLikesByUser(userId);
    }

    @GetMapping("/comment/{commentId}")
    public List<ILike> getLikesByComment(@PathVariable Long commentId) {
        return iLikeService.getLikesByComment(commentId);
    }

    @GetMapping("/count/user/{userId}")
    public long countLikesByUser(@PathVariable Long userId) {
        return iLikeService.countLikesByUser(userId);
    }

    @GetMapping("/count/comment/{commentId}")
    public long countLikesByComment(@PathVariable Long commentId) {
        return iLikeService.countLikesByComment(commentId);
    }
}

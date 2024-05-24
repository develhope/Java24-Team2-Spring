package com.develhope.spring.controllers;

import com.develhope.spring.entities.Comment;
import com.develhope.spring.services.CommentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;

    @PostMapping
    public ResponseEntity<Comment> createComment (@Valid @RequestBody Comment comment, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body((Comment) bindingResult.getAllErrors());
        } else {
            return ResponseEntity.ok(commentService.createComment(comment));
        }
    }

    @GetMapping
    public  ResponseEntity<List<Comment>> getAllComment (){
        return ResponseEntity.ok().body(commentService.getAllComment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getASingleComment(@PathVariable Long id){
        return ResponseEntity.ok().body(commentService.getCommentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment(@Valid @PathVariable Long id, @RequestBody Comment comment) throws Exception {
        Comment updatedComment = commentService.updateComment(comment, id);
        try {
            if (updatedComment != null) {
                return ResponseEntity.ok(updatedComment);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllComment() {
        commentService.deleteAllComment();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable Long id) {
        commentService.deleteCommentById(id);
        return ResponseEntity.noContent().build();
    }
}

package co.develhope.spring.controllers;

import co.develhope.spring.entities.Comment;
import co.develhope.spring.services.CommentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;

    @PostMapping
    public ResponseEntity<?> createComment (@Valid @RequestBody Comment comment, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body((Comment) bindingResult.getAllErrors());
        }
        try {
            return ResponseEntity.ok().body(commentService.createComment(comment));
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getASingleComment(@PathVariable Long id){
        try {
            return ResponseEntity.ok(commentService.getCommentById(id));
        } catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment(@Valid @PathVariable Long id, @RequestBody Comment comment, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try {
            return ResponseEntity.ok().body(commentService.updateComment(comment, id));
        } catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCommentById(@PathVariable Long id) {
        try{
            commentService.deleteCommentById(id);
            return ResponseEntity.ok("Comment deleted");
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

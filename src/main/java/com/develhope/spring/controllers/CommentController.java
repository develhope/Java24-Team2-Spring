package com.develhope.spring.controllers;

import com.develhope.spring.entities.Comment;
import com.develhope.spring.services.CommentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
            return new ResponseEntity<>(commentService.createComment(comment), HttpStatus.CREATED);
        }
    }

    @GetMapping
    public  ResponseEntity<List<Comment>> getAllComment (){
        return ResponseEntity.ok().body(this.commentService.getAllComment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getASingleComment(@PathVariable Long id){
        return new ResponseEntity<>(commentService.getCommentById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@Valid @PathVariable Long id, @RequestBody Comment comment) throws Exception {
        Comment updatedComment = commentService.updateComment(comment, id);
        if (updatedComment != null) {
            return new ResponseEntity<>(updatedComment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllComment() {
        commentService.deleteAllComment();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable Long id) {
        commentService.deleteCommentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

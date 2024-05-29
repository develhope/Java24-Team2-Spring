package com.develhope.spring.controllers;

import com.develhope.spring.dtos.ArticlesDTO;
import com.develhope.spring.entities.Articles;
import com.develhope.spring.repositories.ArticlesRepository;
import com.develhope.spring.services.ArticlesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    @Autowired
    private ArticlesService articlesService;
    @Autowired
    private ArticlesRepository articlesRepository;


    @PostMapping
    public ResponseEntity<?> createArticle (@Valid @RequestBody Articles articles, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body((Articles) bindingResult.getAllErrors());
        }
        try {
            return ResponseEntity.ok().body(articlesService.createArticle(articles));
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Articles>> getAllArticle(){
        return ResponseEntity.ok().body(articlesService.getAllArticle());
    }


    @GetMapping("{id}")
    public ResponseEntity<?> getArticleById(@PathVariable Long id) {
            try {
                ArticlesDTO articlesDTO = articlesService.getArticleById(id);
                return ResponseEntity.ok(articlesDTO);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> upArticle(@Valid @RequestBody ArticlesDTO articlesDTO, BindingResult bindingResult, @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try {
            ArticlesDTO updatedArticle = articlesService.upArticle(articlesDTO,id);
            return ResponseEntity.ok(updatedArticle);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticleById(@PathVariable Long id) {
        try {
            articlesService.deleteArticleById(id);
            return ResponseEntity.ok("Articolo eliminato");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    @DeleteMapping
    public ResponseEntity<Void> deleteAllArticles() {
        articlesService.deleteAllArticles();
        return ResponseEntity.noContent().build();
    }






}

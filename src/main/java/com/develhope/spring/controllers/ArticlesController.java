package com.develhope.spring.controllers;

import com.develhope.spring.entities.Articles;
import com.develhope.spring.services.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    @Autowired
    private ArticlesService articlesService;


    @PostMapping
    public ResponseEntity<?> createArticle(@RequestBody Articles articles){
        try{
            Articles createdArticles = articlesService.createArticle(articles);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdArticles);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @GetMapping("/list")
    public ResponseEntity<List<Articles>> getAllArticle(){
        return ResponseEntity.ok().body(articlesService.getAllArticle());
    }


    @GetMapping("{id}")
    public ResponseEntity<Articles> getArticleById(@PathVariable Long id) {
        return ResponseEntity.ok().body(articlesService.getArticleById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Articles> upArticle(@RequestBody Articles modifiedArticle, @PathVariable Long id) {
        Articles modArticles = articlesService.upArticle(modifiedArticle, id);
        if (modArticles != null) {
            return  ResponseEntity.ok().body(modifiedArticle);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticleById(@PathVariable Long id) {
        articlesService.deleteArticleById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllArticles() {
        articlesService.deleteAllArticles();
        return ResponseEntity.noContent().build();
    }






}

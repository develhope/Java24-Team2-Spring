package com.develhope.spring.controllers;

import com.develhope.spring.entities.Articles;
import com.develhope.spring.services.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    @Autowired
    private ArticlesService articlesService;

    @PostMapping
    public ResponseEntity<?> createArticle(@RequestBody Articles articles){
        try{
            Articles createdArticles = articlesService.saveArticle(articles);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdArticles);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}

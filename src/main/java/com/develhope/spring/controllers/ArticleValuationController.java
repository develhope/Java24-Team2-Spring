package com.develhope.spring.controllers;

import com.develhope.spring.entities.ArticleValuation;
import com.develhope.spring.entities.Articles;
import com.develhope.spring.repositories.ArticleValuationRepo;
import com.develhope.spring.services.ArticleValuationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/valutazioneArticolo")
public class ArticleValuationController {
    @Autowired
    private ArticleValuationService articleValuationService;
    @Autowired
    private ArticleValuationRepo articleValuationRepo;




    @PostMapping
    public ResponseEntity<String> createArticleValuation(@RequestBody ArticleValuation articleValuation) {
        if (articleValuation.getRating() < 1 || articleValuation.getRating() > 5) {
            return ResponseEntity.badRequest().body("Il punteggio deve essere compreso tra 1 e 5.");
        }
        ArticleValuation articleValuation1 = articleValuationService.createArticleValuation(articleValuation);
        articleValuationRepo.save(articleValuation1);

        return ResponseEntity.ok("Valutazione aggiunta con successo.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleValuation> upArticleValuation(@RequestBody ArticleValuation modifiedValuation, @PathVariable Long id) {
        ArticleValuation modifiedV = articleValuationService.upArticleValuation(modifiedValuation, id);
        if (modifiedV != null) {
            return  ResponseEntity.ok().body(modifiedV);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteValuationById(@PathVariable Long id) {
        articleValuationService.deleteValuationById(id);
        return ResponseEntity.noContent().build();
    }

}






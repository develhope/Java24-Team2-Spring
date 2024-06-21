package co.develhope.spring.controllers;

import co.develhope.spring.entities.ArticleValuation;
import co.develhope.spring.services.ArticleValuationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles-valuation")
public class ArticleValuationController {
    @Autowired
    private ArticleValuationService articleValuationService;

    @PostMapping("/{id}")
    public ResponseEntity<?> createArticleValuation(@RequestBody ArticleValuation articleValuation,@PathVariable Long id) {
        try {
            if (articleValuation.getRating() < 1 || articleValuation.getRating() > 5) {
                return ResponseEntity.badRequest().body("Il punteggio deve essere compreso tra 1 e 5.");
            }
            ArticleValuation articleValuation1 = articleValuationService.createArticleValuation(articleValuation, id);
            return ResponseEntity.ok().body("Valutazione aggiunta con successo con valore: " + articleValuation1.getRating());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/avgValuation")
    public ResponseEntity<Float> getAvgArticleValuation(Long id){
        return ResponseEntity.ok(articleValuationService.getAvgArticleValuation(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleValuation> upArticleValuation(@RequestBody ArticleValuation modifiedValuation, @PathVariable Long id) {
        ArticleValuation modifiedV = articleValuationService.upArticleValuation(modifiedValuation, id);
        if (modifiedV != null) {
            return ResponseEntity.ok().body(modifiedV);
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






package co.develhope.spring.controllers;

import co.develhope.spring.enums.Category;
import co.develhope.spring.services.ArticleStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles-stats")
public class ArticleStatsController {

    @Autowired
    private ArticleStatsService articleStatsService;

    @GetMapping("/articles-per-day")
    public ResponseEntity<Double> numberOfArticlesPerDay() {
        return ResponseEntity.ok().body(articleStatsService.averageNumberOfArticlePerDay());
    }

    @GetMapping("/articles-per-category")
    public ResponseEntity<Long> numberOfArticlesPerCategory(@RequestParam Category category) {
        return ResponseEntity.ok().body(articleStatsService.numberOfArticlesByCategory(category));
    }
}

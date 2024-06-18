package co.develhope.spring.controllers;

import co.develhope.spring.dtos.ArticleDTO;
import co.develhope.spring.entities.Article;
import co.develhope.spring.repositories.ArticleRepository;
import co.develhope.spring.services.ArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping
    public ResponseEntity<?> createArticle (@Valid @RequestBody Article article, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body((Article) bindingResult.getAllErrors());
        }
        try {
            return ResponseEntity.ok().body(articleService.createArticle(article));
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Article>> getAllArticle(){
        return ResponseEntity.ok().body(articleService.getAllArticle());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getArticleById(@PathVariable Long id) {
            try {
                ArticleDTO articleDTO = articleService.getArticleById(id);
                return ResponseEntity.ok(articleDTO);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> upArticle(@Valid @RequestBody ArticleDTO articleDTO, BindingResult bindingResult, @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try {
            ArticleDTO updatedArticle = articleService.upArticle(articleDTO,id);
            return ResponseEntity.ok(updatedArticle);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticleById(@PathVariable Long id) {
        try {
            articleService.deleteArticleById(id);
            return ResponseEntity.ok("Articolo eliminato");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllArticles() {
        articleService.deleteAllArticles();
        return ResponseEntity.noContent().build();
    }






}

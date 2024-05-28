package com.develhope.spring.services;



import com.develhope.spring.dtoconerters.ArticleMapper;
import com.develhope.spring.dtos.ArticlesDTO;
import com.develhope.spring.entities.Articles;
import com.develhope.spring.repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServImpl implements ArticlesService{
    @Autowired
    private ArticlesRepository articlesRepository;
    @Autowired
    private ArticleMapper articleMapper;


    public Articles createArticle(Articles articles){
            articles.setPostingDate(new Date());
            return articlesRepository.saveAndFlush(articles);
    }

    public List<Articles> getAllArticle(){
        return articlesRepository.findAll();
    }


    public ArticlesDTO getArticleById(Long id) {
        Articles articles = articlesRepository.findById(id).orElseThrow(()->new IllegalArgumentException("L'articolo non è presente"));
        return articleMapper.toDTO(articles);
    }

    public ArticlesDTO upArticle(ArticlesDTO articlesDTO, Long id) {
        Articles articles = articlesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("L'articolo non è presente"));
        articles.setTitle(articlesDTO.getTitle());
        articles.setText(articlesDTO.getText());
        articles.setCategory(articlesDTO.getCategory());
        articles.setPostingDate(articlesDTO.getPostingDate());

        Articles updatedArticle = articlesRepository.saveAndFlush(articles);
        return articleMapper.toDTO(updatedArticle);
    }

    public void deleteArticleById(Long id) {
            Optional<Articles> optionalArticles = articlesRepository.findById(id);
            if (optionalArticles.isPresent()) {
                articlesRepository.deleteById(id);
            } else {
                throw new IllegalArgumentException("Articolo non trovato");
            }
    }


    public void deleteAllArticles() {
        articlesRepository.deleteAll();
    }


}

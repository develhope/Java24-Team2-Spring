package co.develhope.spring.services;

import co.develhope.spring.entities.Article;
import co.develhope.spring.entities.ArticleValuation;
import co.develhope.spring.repositories.ArticleRepository;
import co.develhope.spring.repositories.ArticleValuationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
@Service
public class ArticleValuationServImpl implements ArticleValuationService {
    @Autowired
    private ArticleValuationRepo articleValuationRepo;
    @Autowired
    private ArticleRepository articleRepository;

    public ArticleValuation createArticleValuation(ArticleValuation articlesVal){

        Article article = articleRepository.findById(articlesVal.getArticles().getId())
                .orElseThrow(() -> new RuntimeException("Article not found"));
        articlesVal.setDatePublication(new Date());
        article.setArticleValuation(articlesVal);

        return articleValuationRepo.saveAndFlush(articlesVal);
    }
    public ArticleValuation upArticleValuation(ArticleValuation articleValuation, Long id) {
        Optional<ArticleValuation> optionalArticleValuation= articleValuationRepo.findById(id);
        if(optionalArticleValuation.isPresent()){
            ArticleValuation thisValuation = optionalArticleValuation.get();
            thisValuation.setRating(articleValuation.getRating());
            return articleValuationRepo.saveAndFlush(thisValuation);
        }else{
            return null;
        }
    }

    public void deleteValuationById(Long id) {
        articleValuationRepo.deleteById(id);
    }

}

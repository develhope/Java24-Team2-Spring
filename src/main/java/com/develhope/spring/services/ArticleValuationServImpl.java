package com.develhope.spring.services;

import com.develhope.spring.entities.ArticleValuation;
import com.develhope.spring.entities.Articles;
import com.develhope.spring.repositories.ArticleValuationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
@Service
public class ArticleValuationServImpl implements ArticleValuationService {
    @Autowired
    private ArticleValuationRepo articleValuationRepo;

    public ArticleValuation createArticleValuation(ArticleValuation articlesVal){
        articlesVal.setDatePublication(new Date());

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

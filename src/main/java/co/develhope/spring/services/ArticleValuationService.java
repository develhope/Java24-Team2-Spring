package co.develhope.spring.services;

import co.develhope.spring.entities.ArticleValuation;

public interface ArticleValuationService {
    ArticleValuation createArticleValuation(ArticleValuation articlesValuation);

    Float getAvgArticleValuation(Long id);

    ArticleValuation upArticleValuation(ArticleValuation articleValuation, Long id);

    void deleteValuationById(Long id);
}

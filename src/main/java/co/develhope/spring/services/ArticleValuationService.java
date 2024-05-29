package co.develhope.spring.services;

import co.develhope.spring.entities.ArticleValuation;

public interface ArticleValuationService {
    ArticleValuation createArticleValuation(ArticleValuation articles_details);

    ArticleValuation upArticleValuation(ArticleValuation articleValuation, Long id);

    void deleteValuationById(Long id);
}

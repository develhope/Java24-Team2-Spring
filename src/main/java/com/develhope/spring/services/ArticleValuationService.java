package com.develhope.spring.services;

import com.develhope.spring.entities.ArticleValuation;

public interface ArticleValuationService {
    ArticleValuation createArticleValuation(ArticleValuation articles_details);

    ArticleValuation upArticleValuation(ArticleValuation articleValuation, Long id);

    void deleteValuationById(Long id);
}

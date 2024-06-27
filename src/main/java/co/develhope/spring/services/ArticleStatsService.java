package co.develhope.spring.services;

import co.develhope.spring.enums.Category;

public interface ArticleStatsService {
    Double averageNumberOfArticlePerDay();

    Long numberOfArticlesByCategory(Category category);
}

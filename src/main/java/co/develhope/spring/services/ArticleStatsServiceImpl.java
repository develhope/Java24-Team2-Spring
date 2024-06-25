package co.develhope.spring.services;

import co.develhope.spring.enums.Category;
import co.develhope.spring.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleStatsServiceImpl implements ArticleStatsService{
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Double averageNumberOfArticlePerDay() {
        return articleRepository.averageNumberOfArticlesPerDay();
    }

    @Override
    public Long numberOfArticlesByCategory(Category category) {
        return articleRepository.countByCategory(category);
    }
}

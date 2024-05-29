package co.develhope.spring.services;

import co.develhope.spring.dtos.ArticlesDTO;
import co.develhope.spring.entities.Articles;

import java.util.List;

public interface ArticlesService {

Articles createArticle(Articles articles);

List<Articles> getAllArticle();

ArticlesDTO getArticleById(Long id);

ArticlesDTO upArticle(ArticlesDTO articlesDTO, Long id);

void deleteArticleById(Long id);

void deleteAllArticles();

}

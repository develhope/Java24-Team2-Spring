package com.develhope.spring.services;

import com.develhope.spring.dtos.ArticlesDTO;
import com.develhope.spring.entities.Articles;

import java.util.List;

public interface ArticlesService {

Articles createArticle(Articles articles);

List<Articles> getAllArticle();

ArticlesDTO getArticleById(Long id);

ArticlesDTO upArticle(ArticlesDTO articlesDTO, Long id);

void deleteArticleById(Long id);

void deleteAllArticles();

}

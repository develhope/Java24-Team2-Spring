package com.develhope.spring.services;

import com.develhope.spring.entities.Articles;

import java.util.List;

public interface ArticlesService {

Articles createArticle(Articles articles);

List<Articles> getAllArticle();

Articles getArticleById(Long id);

Articles upArticle(Articles articles, Long id);

void deleteArticleById(Long id);

void deleteAllArticles();

}

package com.develhope.spring.services;

import com.develhope.spring.entities.Articles;
import com.develhope.spring.repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;

@Service
public class ArticleServImpl implements ArticlesService{
    @Autowired
    private ArticlesRepository articlesRepository;

    public Articles saveArticle(Articles articles){
        articles.setPostingDate(new Date());

        return articlesRepository.save(articles);
    }
}

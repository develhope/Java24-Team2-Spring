package com.develhope.spring.services;

import com.develhope.spring.entities.Article_details;
import com.develhope.spring.entities.Articles;
import com.develhope.spring.repositories.Article_detailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class Article_detailsServImpl implements Article_detailService {
    @Autowired
    private Article_detailsRepository articleDetailsRepository;

    public Article_details saveArticleDetail(Article_details articles_details){
        articles_details.setDatePublication(new Date());

        return articleDetailsRepository.save(articles_details);
    }
}

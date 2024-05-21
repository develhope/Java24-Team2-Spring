package com.develhope.spring.services;

import com.develhope.spring.controllers.ArticlesController;
import com.develhope.spring.entities.Article_details;

public interface Article_detailService {
    Article_details saveArticleDetail(Article_details articles_details);
}

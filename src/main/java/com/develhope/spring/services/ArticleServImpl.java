package com.develhope.spring.services;



import com.develhope.spring.entities.Articles;
import com.develhope.spring.repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServImpl implements ArticlesService{
    @Autowired
    private ArticlesRepository articlesRepository;


    public Articles createArticle(Articles articles){
        articles.setPostingDate(new Date());

        return articlesRepository.saveAndFlush(articles);
    }

    public List<Articles> getAllArticle(){
        return articlesRepository.findAll();
    }


    public Articles getArticleById(Long id) {
        Optional<Articles> article = articlesRepository.findById(id);
        return article.orElse(null);
    }

    public Articles upArticle(Articles articles, Long id) {
        Optional <Articles> optionalArticles= articlesRepository.findById(id);
        if(optionalArticles.isPresent()){
            Articles presentArticle = optionalArticles.get();
            presentArticle.setText(articles.getText());
//            presentArticle.setTags(articles.getTags());
            presentArticle.setTitle(articles.getTitle());
            presentArticle.setCategory(articles.getCategory());
            return articlesRepository.saveAndFlush(presentArticle);
        }else{
            return null;
        }
    }

    public void deleteArticleById(Long id) {
        articlesRepository.deleteById(id);
    }


    public void deleteAllArticles() {
        articlesRepository.deleteAll();
    }


}

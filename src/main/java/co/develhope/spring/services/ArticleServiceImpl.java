package co.develhope.spring.services;

import co.develhope.spring.dtoconverters.ArticleMapper;
import co.develhope.spring.dtos.ArticleDTO;
import co.develhope.spring.entities.Article;
import co.develhope.spring.entities.User;
import co.develhope.spring.enums.Category;
import co.develhope.spring.exceptions.UserNotFoundException;
import co.develhope.spring.repositories.ArticleRepository;
import co.develhope.spring.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Article createArticle(Article article){
        User user = userRepository.findById(article.getUser().getId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

            article.setPostingDate(LocalDateTime.now());
            article.setUser(user);
            return articleRepository.saveAndFlush(article);
    }

    @Override
    public List<Article> getAllArticle(){
        return articleRepository.findAll();
    }

    @Override
    public List<Article> getAllArticleByCategory(Category category) {
        return articleRepository.findAllByCategory(category);
    }

    @Override
    public ArticleDTO getArticleById(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Article not found"));
        return articleMapper.toDTO(article);
    }

    @Override
    public ArticleDTO upArticle(ArticleDTO articleDTO, Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Article not found"));
        article.setTitle(articleDTO.getTitle());
        article.setText(articleDTO.getText());
        article.setCategory(articleDTO.getCategory());
        article.setPostingDate(articleDTO.getPostingDate());

        Article updatedArticle = articleRepository.saveAndFlush(article);
        return articleMapper.toDTO(updatedArticle);
    }

    @Override
    public void deleteArticleById(Long id) {
            Optional<Article> optionalArticles = articleRepository.findById(id);
            if (optionalArticles.isPresent()) {
                articleRepository.deleteById(id);
            } else {
                throw new IllegalArgumentException("Article not found");
            }
    }

    @Override
    public void deleteAllArticles() {
        articleRepository.deleteAll();
    }
}

package co.develhope.spring.services;

import co.develhope.spring.entities.Article;
import co.develhope.spring.entities.ArticleValuation;
import co.develhope.spring.entities.User;
import co.develhope.spring.exceptions.UserNotFoundException;
import co.develhope.spring.repositories.ArticleRepository;
import co.develhope.spring.repositories.ArticleValuationRepository;
import co.develhope.spring.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ArticleValuationServiceImpl implements ArticleValuationService {
    @Autowired
    private ArticleValuationRepository articleValuationRepo;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ArticleValuation createArticleValuation(ArticleValuation articlesVal){
        Article article = articleRepository.findById(articlesVal.getArticles().getId())
                .orElseThrow(() -> new EntityNotFoundException("Articolo non trovato"));

        User user = userRepository.findById(articlesVal.getUser().getId())
                .orElseThrow(() -> new UserNotFoundException("Utente non trovato"));

        articlesVal.setDatePublication(LocalDate.now());
        articlesVal.setArticles(article);
        articlesVal.setUser(user);

        return articleValuationRepo.saveAndFlush(articlesVal);
    }

    @Override
    public Float getAvgArticleValuation(Long id) {
        return articleValuationRepo.avgOfSingleValuation(id);
    }

    @Override
    public ArticleValuation upArticleValuation(ArticleValuation articleValuation, Long id) {
        Optional<ArticleValuation> optionalArticleValuation= articleValuationRepo.findById(id);
        if(optionalArticleValuation.isPresent()){
            ArticleValuation thisValuation = optionalArticleValuation.get();
            thisValuation.setRating(articleValuation.getRating());
            return articleValuationRepo.saveAndFlush(thisValuation);
        }else{
            return null;
        }
    }

    @Override
    public void deleteValuationById(Long id) {
        articleValuationRepo.deleteById(id);
    }
}

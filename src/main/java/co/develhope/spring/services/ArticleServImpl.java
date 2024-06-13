package co.develhope.spring.services;



import co.develhope.spring.dtoconverters.ArticleMapper;
import co.develhope.spring.dtos.ArticleDTO;
import co.develhope.spring.entities.Article;
import co.develhope.spring.entities.User;
import co.develhope.spring.repositories.ArticleRepository;
import co.develhope.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private UserRepository userRepository;


    public Article createArticle(Article article){
        User user = userRepository.findById(article.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

            article.setPostingDate(new Date());
            article.setUser(user);
            return articleRepository.saveAndFlush(article);
    }

    public List<Article> getAllArticle(){
        return articleRepository.findAll();
    }


    public ArticleDTO getArticleById(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(()->new IllegalArgumentException("L'articolo non è presente"));
        return articleMapper.toDTO(article);
    }

    public ArticleDTO upArticle(ArticleDTO articleDTO, Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("L'articolo non è presente"));
        article.setTitle(articleDTO.getTitle());
        article.setText(articleDTO.getText());
        article.setCategory(articleDTO.getCategory());
        article.setPostingDate(articleDTO.getPostingDate());

        Article updatedArticle = articleRepository.saveAndFlush(article);
        return articleMapper.toDTO(updatedArticle);
    }

    public void deleteArticleById(Long id) {
            Optional<Article> optionalArticles = articleRepository.findById(id);
            if (optionalArticles.isPresent()) {
                articleRepository.deleteById(id);
            } else {
                throw new IllegalArgumentException("Articolo non trovato");
            }
    }


    public void deleteAllArticles() {
        articleRepository.deleteAll();
    }


}

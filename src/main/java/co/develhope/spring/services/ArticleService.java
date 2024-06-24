package co.develhope.spring.services;

import co.develhope.spring.dtos.ArticleDTO;
import co.develhope.spring.entities.Article;
import co.develhope.spring.enums.Category;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {

Article createArticle(Article article, MultipartFile articleImage, String bucketName, String destinationFolderName);

List<Article> getAllArticle();

List<Article> getAllArticleByCategory(Category category);

ArticleDTO getArticleById(Long id);



ArticleDTO upArticle(ArticleDTO articleDTO, Long id);

void deleteArticleById(Long id);

void deleteAllArticles();

}

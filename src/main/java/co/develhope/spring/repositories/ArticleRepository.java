package co.develhope.spring.repositories;

import co.develhope.spring.entities.Article;
import co.develhope.spring.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    /* per calcolare la media degli articoli postati al giorno
    fai la conta degli articoli / conta giorni tra data corrente e data primo articolo */
    @Query(value = "COUNT(*) / DATEDIFF(CURDATE(), MIN(posting_date)) FROM articles", nativeQuery = true)
    Double averageNumberOfArticlesPerDay();

    Long countByCategory(Category category);

    List<Article> findAllByCategory(Category category);
}

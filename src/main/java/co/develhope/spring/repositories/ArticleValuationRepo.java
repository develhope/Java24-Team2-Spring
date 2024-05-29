package co.develhope.spring.repositories;

import co.develhope.spring.entities.ArticleValuation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleValuationRepo extends JpaRepository<ArticleValuation,Long> {

}

package co.develhope.spring.repositories;

import co.develhope.spring.entities.ArticleValuation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleValuationRepository extends JpaRepository<ArticleValuation,Long> {

    @Query("SELECT AVG(av.rating) FROM ArticleValuation av WHERE av.id = :valuationId")
    Float avgOfSingleValuation(@Param("valuationId") Long valuationId);

    @Query(value = "SELECT AVG(av.rating) FROM article_valuation av JOIN article a ON av.article_id = a.id " +
            "JOIN user u ON av.user_valuating_id = u.id " +
            "WHERE u.id = :user_id", nativeQuery = true)
    Float avgValuationPerUser(@Param("user_id") Long user_id);
}

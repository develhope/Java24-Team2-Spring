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

    @Query(value = "SELECT AVG(av.rating) FROM articles_valuations av JOIN articles a ON av.articles_id = a.id " +
            "JOIN users u ON av.user_id = u.id " +
            "WHERE u.id = :user_id", nativeQuery = true)
    Float avgValuationPerUser(@Param("user_id") Long user_id);
}

package co.develhope.spring.repositories;

import co.develhope.spring.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    //conta quanti commenti ci sono
    @Query("SELECT COUNT(c) FROM Comment c")
    int countTotalComments();

    //Media di caratteri dei commenti
    @Query("SELECT AVG(LENGTH(c.text)) FROM Comment c")
    double averageCommentLength();

    //Conta i commenti per gli utenti
    @Query("SELECT c.user.username, COUNT(c) FROM Comment c GROUP BY c.user.id ORDER BY COUNT(c) DESC")
    List<Object[]> countCommentForUsers();

    @Query("SELECT c.article.title, COUNT(c) FROM Comment c GROUP BY c.article.id ORDER BY COUNT(c) DESC")
    List<Object[]> countCommentForArticle();
}

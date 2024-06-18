package co.develhope.spring.repositories;

import co.develhope.spring.entities.Follow;
import co.develhope.spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findByFollower(User follower);

    @Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END FROM Follow f WHERE f.follower.id = :followerId AND f.user.id = :userId") // Aggiornata la query JPQL e i metodi per usare 'user' invece di 'followed'.
    boolean existsByFollowerIdAndUserId(@Param("followerId") Long followerId, @Param("userId") Long userId);

    Follow findByFollowerAndUser(User follower, User user);
}
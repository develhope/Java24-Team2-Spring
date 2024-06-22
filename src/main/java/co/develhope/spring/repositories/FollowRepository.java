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
    List<Follow> findAllByUser(User follower);

    List<Follow> findAllByFollower(User user);

    @Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END " +
            "FROM Follow f WHERE f.follower.id = :followerId AND f.user.id = :userId")
    Boolean existsByFollowerIdAndUserId(@Param("followerId") Long followerId, @Param("userId") Long userId);

    @Query("SELECT COUNT(f) FROM Follow f WHERE f.user.id = :userId")
    Long countFollowersByUserId(@Param("userId") Long userId);

    @Query("SELECT COUNT(f) FROM Follow f WHERE f.follower.id = :userId")
    Long countFollowingByFollowerId(@Param("userId") Long userId);


}
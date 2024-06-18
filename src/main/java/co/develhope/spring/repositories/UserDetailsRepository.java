package co.develhope.spring.repositories;

import co.develhope.spring.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, UUID> {
    @Query(value = "SELECT AVG(YEAR(CURDATE()-YEAR(birthday)) AS average_age FROM user", nativeQuery = true)
    short averageAge();

    @Query(value = "SELECT COUNT(USER) ")
    short numberOfArticlesForUser();
}

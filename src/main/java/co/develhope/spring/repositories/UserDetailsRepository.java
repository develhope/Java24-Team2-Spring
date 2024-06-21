package co.develhope.spring.repositories;

import co.develhope.spring.entities.UserDetails;
import co.develhope.spring.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {
    @Query(value = "SELECT AVG(YEAR(CURDATE()-YEAR(birthday)) AS average_age FROM user", nativeQuery = true)
    Short averageAge();

    Long countByGender(Gender gender);
}

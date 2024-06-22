package co.develhope.spring.repositories;

import co.develhope.spring.entities.UserDetails;
import co.develhope.spring.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {
    @Query(value = "SELECT AVG(TIMESTAMPDIFF(YEAR, birthday, CURDATE())) AS average_age FROM users_details", nativeQuery = true)
    Float averageAge();

    Long countByGender(Gender gender);
}

package co.develhope.spring.repositories;

import co.develhope.spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query(value = "SELECT COUNT(id) FROM users WHERE signup_date >= :initialDate AND signup_date <= :lastDate", nativeQuery = true)
    Long countUsersSignUpPerPeriod(@Param("initialDate") LocalDate initialDate, @Param("lastDate") LocalDate lastDate);
}

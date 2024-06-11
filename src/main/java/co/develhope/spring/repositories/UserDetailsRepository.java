package co.develhope.spring.repositories;

import co.develhope.spring.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, UUID> {
}

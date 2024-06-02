package co.develhope.spring.repositories;

import co.develhope.spring.entities.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Long> {

}

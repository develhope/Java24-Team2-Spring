package com.develhope.spring.repositories;

import com.develhope.spring.entities.Article_details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Article_detailsRepository extends JpaRepository<Article_details,Long> {

}

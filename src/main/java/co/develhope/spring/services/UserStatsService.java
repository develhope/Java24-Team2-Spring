package co.develhope.spring.services;

import java.time.LocalDate;

public interface UserStatsService {

    Long countUsersByPeriod(LocalDate initialDate, LocalDate lastDate);

    Float avgArticleValuationPerUser(Long id);

    Float avgAge();

    String percentageOfUsersByGender();
}

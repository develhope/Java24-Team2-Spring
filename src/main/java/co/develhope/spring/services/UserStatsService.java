package co.develhope.spring.services;

import co.develhope.spring.dtos.UserDetailsDto;

import java.time.LocalDate;
import java.util.HashMap;

public interface UserStatsService {
    short averageAgeOfUsers();

    HashMap<String, Integer> CounterOfUserBySignUpRange(LocalDate start, LocalDate end);
}

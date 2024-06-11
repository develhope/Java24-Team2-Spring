package co.develhope.spring.services;

import co.develhope.spring.repositories.UserDetailsRepository;
import co.develhope.spring.repositories.UserRepository;
import co.develhope.spring.repositories.UserStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;

@Service
public class UserStatsServiceImpl implements UserStatsService {

    @Autowired
    UserStatsRepository userStatsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public short averageAgeOfUsers() {
     return userStatsRepository.averageAge();
    }

    @Override
    public HashMap<String, Integer> CounterOfUserBySignUpRange(LocalDate start, LocalDate end) {
        return null;
    }
}

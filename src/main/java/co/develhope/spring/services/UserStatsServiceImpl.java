package co.develhope.spring.services;

import co.develhope.spring.repositories.UserDetailsRepository;
import co.develhope.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
// media follow, media valutazioni, numeri commenti, numeri di like, quanti commenti ci sono per ogni post in media
// response entity incoerenza non tornare stringhe
// quanti post fanno gli utenti in relazione all'età, media valutazione utente
// media valutazione post
@Service
public class UserStatsServiceImpl implements UserStatsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public short averageAgeOfUsers() {
     return userDetailsRepository.averageAge();
    }

    @Override
    public HashMap<String, Integer> CounterOfUserBySignUpRange(LocalDate start, LocalDate end) {
        return null;
    }
}

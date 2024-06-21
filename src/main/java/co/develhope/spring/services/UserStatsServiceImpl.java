package co.develhope.spring.services;

import co.develhope.spring.entities.User;
import co.develhope.spring.enums.Gender;
import co.develhope.spring.exceptions.UserNotFoundException;
import co.develhope.spring.repositories.ArticleValuationRepository;
import co.develhope.spring.repositories.UserDetailsRepository;
import co.develhope.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserStatsServiceImpl implements UserStatsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Autowired
    ArticleValuationRepository articleValuationRepository;

    @Override
    public Long countUsersByPeriod(LocalDate initialDate, LocalDate lastDate) {
        return userRepository.countUsersSignUpPerPeriod(initialDate, lastDate);
    }

    @Override
    public Float avgArticleValuationPerUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return articleValuationRepository.avgValuationPerUser(user.getId());
    }

    @Override
    public Short avgAge() {
        return userDetailsRepository.averageAge();
    }

    @Override
    public Double percentageOfUsersByGender() {
        Long numberOfMales = userDetailsRepository.countByGender(Gender.MALE);
        Long numberOfFemales = userDetailsRepository.countByGender(Gender.FEMALE);
        Long numberOfNoBinary = userDetailsRepository.countByGender(Gender.NOBINARY);

        long totalUsers = numberOfMales + numberOfFemales + numberOfNoBinary;

        Double percentageOfMales = (double) numberOfMales / totalUsers * 100;
        Double percentageOfFemales = (double) numberOfFemales / totalUsers * 100;
        Double percentageOfNonBinary = (double) numberOfNoBinary / totalUsers * 100;
        return percentageOfMales + percentageOfFemales + percentageOfNonBinary;
    }
}

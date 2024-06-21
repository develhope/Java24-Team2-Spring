package co.develhope.spring.controllers;

import co.develhope.spring.services.UserStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/user-stats")
public class UserStatsController {

    @Autowired
    private UserStatsService userStatsService;

    @GetMapping("/count-users")
    public ResponseEntity<Long> countUsersByPeriod(
            @RequestParam("initialDate") LocalDate initialDate, @RequestParam("lastDate") LocalDate lastDate) {
        Long count = userStatsService.countUsersByPeriod(initialDate, lastDate);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/avg-article-valuation")
    public ResponseEntity<Float> avgArticleValuationPerUser(@RequestParam("userId") Long userId) {
        Float avgValuation = userStatsService.avgArticleValuationPerUser(userId);
        return ResponseEntity.ok(avgValuation);
    }

    @GetMapping("/avg-age")
    public ResponseEntity<Short> avgAge() {
        Short avgAge = userStatsService.avgAge();
        return ResponseEntity.ok(avgAge);
    }

    @GetMapping("/percentage-users-by-gender")
    public ResponseEntity<Double> percentageOfUsersByGender() {
        Double percentage = userStatsService.percentageOfUsersByGender();
        return ResponseEntity.ok(percentage);
    }
}

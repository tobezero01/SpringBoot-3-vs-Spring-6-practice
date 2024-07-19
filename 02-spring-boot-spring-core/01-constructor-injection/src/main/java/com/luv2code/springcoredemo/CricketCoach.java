package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "The work start at 5 AM";
    }
}

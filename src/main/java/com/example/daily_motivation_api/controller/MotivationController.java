package com.example.daily_motivation_api.controller;

import com.example.daily_motivation_api.model.Feedback;
import com.example.daily_motivation_api.service.MotivationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MotivationController {

    @Autowired
    private MotivationService service;

    @GetMapping("/quotes/random")
    public String getRandomQuote() {
        return service.getRandomQuote();
    }

    @GetMapping("/habits/today")
    public String getDailyHabit() {
        return service.getTodayHabit();
    }

    @GetMapping("/challenges/7day")
    public List<String> get7DayChallenge() {
        return service.get7DayChallenge();
    }

    @PostMapping("/feedback")
    public String submitFeedback(@RequestBody Feedback feedback) {
        service.saveFeedback(feedback);
        return "Thank you for your feedback!";
    }

    @GetMapping("/feedback")
    public List<Feedback> getAllFeedback() {
        return service.getAllFeedback();
    }
}
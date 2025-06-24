package com.example.daily_motivation_api.service;

import com.example.daily_motivation_api.model.Feedback;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MotivationService {

    private List<String> quotes = new ArrayList<>();
    private List<String> habits = new ArrayList<>();
    private List<String> challenge = new ArrayList<>();
    private List<Feedback> feedbackList = new ArrayList<>();
    private Random random = new Random();

    @PostConstruct
    public void initData() {
        quotes.add("Push yourself, because no one else is going to do it for you.");
        quotes.add("Don’t watch the clock; do what it does. Keep going.");
        quotes.add("You are capable of amazing things.");
        quotes.add("Small steps every day lead to big results.");
        quotes.add("Dream it. Believe it. Build it.");

        habits.add("Drink 8 glasses of water.");
        habits.add("Take a 10-minute walk.");
        habits.add("Write down 3 things you’re grateful for.");
        habits.add("Read 10 pages of a book.");
        habits.add("Stretch for 5 minutes.");

        challenge.add("Day 1: Wake up 30 minutes early.");
        challenge.add("Day 2: Avoid junk food.");
        challenge.add("Day 3: Practice 15 minutes of meditation.");
        challenge.add("Day 4: No social media.");
        challenge.add("Day 5: Call a loved one.");
        challenge.add("Day 6: Journal your thoughts.");
        challenge.add("Day 7: Reflect on your week.");
    }

    public String getRandomQuote() {
        return quotes.get(random.nextInt(quotes.size()));
    }

    public String getTodayHabit() {
        Calendar calendar = Calendar.getInstance();
        int index = calendar.get(Calendar.DAY_OF_WEEK) % habits.size();
        return habits.get(index);
    }

    public List<String> get7DayChallenge() {
        return challenge;
    }

    public void saveFeedback(Feedback feedback) {
        feedbackList.add(feedback);
    }

    public List<Feedback> getAllFeedback() {
        return feedbackList;
    }
}

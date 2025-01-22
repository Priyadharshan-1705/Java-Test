package com.example.datingapp.controller;

import com.example.datingapp.model.User;
import com.example.datingapp.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @PostMapping("/matches")
    public List<User> getMatches(@RequestBody User currentUser , @RequestParam int topN) {
        return recommendationService.getTopMatches(currentUser , topN);
    }
}
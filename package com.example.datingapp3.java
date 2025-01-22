package com.example.datingapp.service;

import com.example.datingapp.model.User;
import com.example.datingapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RecommendationServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RecommendationService recommendationService;

    public RecommendationServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetTopMatches() {
        User user1 = new User("User  1", "Female", 25, Arrays.asList("Cricket", "Chess"));
        User user2 = new User("User  2", "Male", 27, Arrays.asList("Cricket", "Football", "Movies"));
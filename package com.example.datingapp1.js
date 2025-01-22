package com.example.datingapp.service;

import com.example.datingapp.model.User;
import com.example.datingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getTopMatches(User currentUser , int topN) {
        List<User> users = userRepository.findAll();
        users.remove(currentUser ); 
        
        return users.stream()
                .sorted(Comparator.comparing((User  user) -> !user.getGender().equals(currentUser .getGender())) // Gender preference
                        .thenComparing(user -> Math.abs(user.getAge() - currentUser .getAge())) // Age preference
                        .thenComparing(user -> getInterestMatchCount(user, currentUser ))) // Interest preference
                .limit(topN)
                .collect(Collectors.toList());
    }

    private int getInterestMatchCount(User user1, User user2) {
        Set<String> interests1 = new HashSet<>(user1.getInterests());
        Set<String> interests2 = new HashSet<>(user2.getInterests());
        interests1.retainAll(interests2);
        return interests1.size();
    }
}
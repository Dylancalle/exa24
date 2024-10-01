package com.example.clientservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public User saveUser(User user) {
        users.add(user);
        return user;
    }
}

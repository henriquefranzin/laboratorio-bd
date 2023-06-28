package com.projeto.controller;

import com.projeto.model.User;
import com.projeto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    public UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserController() {
    }

    @GetMapping
    public User findUserByLogin(@RequestParam String login) {
        return userRepository.findByLogin(login);
    }
}

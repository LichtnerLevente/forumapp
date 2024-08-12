package com.example.forumapp.service;


import com.example.forumapp.model.entities.User;
import com.example.forumapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(Long id) {
        return userRepository.getReferenceById(id);
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User editUser(User user, Long id) {
        return userRepository.save(user);
    }


    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}

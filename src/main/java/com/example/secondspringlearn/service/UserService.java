package com.example.secondspringlearn.service;


import com.example.secondspringlearn.exception.UserNotFoundException;
import com.example.secondspringlearn.model.User;
import com.example.secondspringlearn.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public void add(User user) {
        userRepository.add(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void remove(long id) {
        userRepository.remove(id);
    }

    public User getById(long id) {
        User user = userRepository.getById(id);
        if (user == null) {
            throw new UserNotFoundException(String.format("User with id %d not found", id));
        }
        return user;
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public Collection<User> getAll() {
        return userRepository.getAll();
    }
}
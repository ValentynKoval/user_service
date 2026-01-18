package com.example.secondspringlearn.repository;

import com.example.secondspringlearn.model.User;

public interface UserRepository {

    void add(User user);
    void update(User user);
    void remove(long id);
    User getById(long id);
    java.util.Collection<User> getAll();

    User getByEmail(String email);
}

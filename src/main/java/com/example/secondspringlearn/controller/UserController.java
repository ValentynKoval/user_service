package com.example.secondspringlearn.controller;


import com.example.secondspringlearn.model.User;
import com.example.secondspringlearn.service.UserService;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        userService.add(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    @DeleteMapping("/remove")
    public void remove(@RequestParam long id) {
        userService.remove(id);
    }

    @GetMapping("/getById/{id}")
    public User getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @GetMapping("/getAll")
    @Timed(value = "endpoint.users.getAll", description = "Time spent on getAll endpoint")
    public Collection<User> getAll() {
        return userService.getAll();
    }
}
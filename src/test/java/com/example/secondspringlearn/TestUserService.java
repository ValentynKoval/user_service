package com.example.secondspringlearn;


import com.example.secondspringlearn.model.User;
import com.example.secondspringlearn.repository.UserRepositoryJPA;
import com.example.secondspringlearn.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TestUserService {
    @Autowired
    private UserService userService;

    @MockitoBean
    private UserRepositoryJPA userRepositoryJPA;

//    @Test
//    void getAllUsersTest() {
//        when(userRepositoryJPA.findAll()).thenReturn(List.of(new User(1, "Bob", "bob@gmail.com")));
//        assertEquals(1, userService.getAll().size());
//    }
}

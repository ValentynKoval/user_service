package com.example.secondspringlearn.controller;

import com.example.secondspringlearn.model.Order;
import com.example.secondspringlearn.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @PostMapping("/create")
    public void create(@RequestBody Order order) {
        orderService.create(order);
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<Order> getByEmail(@PathVariable String email) {
        return orderService.getByEmail(email);
    }
}

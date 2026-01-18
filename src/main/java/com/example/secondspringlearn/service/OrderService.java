package com.example.secondspringlearn.service;

import com.example.secondspringlearn.model.Order;
import com.example.secondspringlearn.model.User;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class OrderService {

    private static final Logger LOG = LogManager.getLogger(OrderService.class);

    private RestTemplate restTemplate;
    private UserService userService;

    public void create(Order order) {
        User user = userService.getByEmail(order.getEmail());
        if (user != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Order> requestEntity = new HttpEntity<>(order, headers);

            String url = "http://localhost:8081/external/orders/create";

            restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        }
    }

    public ResponseEntity<Order> getByEmail(String email) {
        ResponseEntity<Order> entity =
                restTemplate.getForEntity(String.format("http://localhost:8081/external/orders/getByEmail/%s", email), Order.class);
        LOG.info(entity.getBody());
        return entity;
    }
}

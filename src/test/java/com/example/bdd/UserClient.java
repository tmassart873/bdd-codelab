package com.example.bdd;

import com.example.bdd.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

@Component
public class UserClient {

    @Value("${server.port}")
    private int port;

    private RestTemplate restTemplate = new RestTemplate();

    public void addUser(User user) {
        restTemplate.postForObject("http://localhost:"+ port + "/users", user, Void.class);
    }
    public List<User> getAllUsers() {
        return newArrayList(restTemplate.getForObject("http://localhost:"+ port + "/users", User[].class));
    }


}
package com.example.bdd.respository;

import com.example.bdd.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {

    private HashMap<UUID, User> users;

    public UserRepository() {
        this.users = new HashMap<>();
    }

    public User save(User user){
        users.put(user.getId(),user);
        return user;
    }

    public List<User> getAllUsers(){
        return users.values().stream().toList();
    }
}

package com.taskplanner.users.service.impl;

import com.taskplanner.users.entities.User;
import com.taskplanner.users.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Laura Garcia
 */
@Service
public class UserServiceHashMap implements UserService {
    private final ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();

    @Override
    public User create(User user) {
        users.putIfAbsent(user.getId(), user);
        return user;
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }

    @Override
    public List<User> getAll() {
        List<User> allUsers = new ArrayList<>();
        for(String key : users.keySet()){
            allUsers.add(users.get(key));
        }
        return allUsers;
    }

//    @Override
//    public User deleteById(String id) {
//        return users.remove(id);
//    }

    @Override
    public void deleteById(String id) {
        users.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        users.replace(userId, user);
        return users.get(userId);
    }
}

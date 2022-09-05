package com.taskplanner.users.service.impl;

import com.taskplanner.users.entities.User;
import com.taskplanner.users.service.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Laura Garcia
 */

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

    @Override
    public boolean deleteById(String id) {
        try{
            users.remove(id);
            return true;
        }catch(NullPointerException e){
            return false;
        }
    }

    @Override
    public User update(User user, String userId) {
        users.replace(userId, user);
        return users.get(userId);
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        return null;
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        return null;
    }
}

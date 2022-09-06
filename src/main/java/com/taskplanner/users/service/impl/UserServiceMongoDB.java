package com.taskplanner.users.service.impl;

import com.taskplanner.users.dto.UserDto;
import com.taskplanner.users.entities.User;
import com.taskplanner.users.repository.UserRepository;
import com.taskplanner.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Laura Garcia
 */
@Service
public class UserServiceMongoDB implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository ){
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        if(findById(id) == null){
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public User update(UserDto user, String userId) {
        User userUpdate = findById(userId);
        userUpdate.update(user);
        return userRepository.save(userUpdate);
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        return userRepository.findByNameLikeOrLastNameLike(queryText, queryText);
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        return userRepository.findByCreatedAtAfter( startDate);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

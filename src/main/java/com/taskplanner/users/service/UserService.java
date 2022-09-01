package com.taskplanner.users.service;

import com.taskplanner.users.entities.User;

import java.util.List;

/**
 * @author Laura Garcia
 */
public interface UserService {
    User create( User user );

    User findById( String id );

    List<User> getAll();

//    User deleteById( String id );

    void deleteById( String id );

    User update(User user, String userId );
}

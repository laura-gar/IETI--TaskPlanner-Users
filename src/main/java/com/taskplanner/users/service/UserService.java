package com.taskplanner.users.service;

import com.taskplanner.users.entities.User;

import java.util.Date;
import java.util.List;

/**
 * @author Laura Garcia
 */
public interface UserService {
    User create( User user );

    User findById( String id );

    List<User> getAll();

    boolean deleteById( String id );

    User update(User user, String userId );

    List<User> findUsersWithNameOrLastNameLike(String queryText);

    List<User> findUsersCreatedAfter(Date startDate);
}

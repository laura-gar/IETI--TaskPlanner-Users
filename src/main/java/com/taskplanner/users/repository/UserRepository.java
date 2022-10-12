package com.taskplanner.users.repository;

import com.taskplanner.users.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

/**
 * @author Laura Garcia
 */
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByNameLikeOrLastNameLike(String queryText, String sQueryText);

    List<User> findByCreatedAtAfter(Date startDate);

    User findByEmail(String email);
}

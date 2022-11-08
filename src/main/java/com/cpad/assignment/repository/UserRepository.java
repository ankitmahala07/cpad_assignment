package com.cpad.assignment.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.cpad.assignment.model.User;

import java.util.Optional;

public interface UserRepository extends ArangoRepository<User,String> {
    Optional<User> findByUsernameAndPassword(String username, String password);
}

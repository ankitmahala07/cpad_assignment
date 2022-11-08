package com.cpad.assignment.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.cpad.assignment.model.Cart;

import java.util.Optional;

public interface CartRepository extends ArangoRepository<Cart,String> {

    Optional<Cart> findByUserId(String userId);

}

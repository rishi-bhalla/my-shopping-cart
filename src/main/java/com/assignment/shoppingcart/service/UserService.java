package com.assignment.shoppingcart.service;

import com.assignment.shoppingcart.model.User;

import java.util.Optional;

/**
 * UserService that specifies the contract associated with the user entity that the implementing
 * class must abide by.
 * All the classes implementing this interface must provide an implementation for the methods declared
 * in this interface.
 */
public interface UserService {

    Optional<User> findByEmail(String email);

    User save(User user);
}

package com.assignment.shoppingcart.service;

import com.assignment.shoppingcart.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByEmail(String email);

    User save(User user);
}

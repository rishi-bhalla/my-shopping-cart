package com.assignment.shoppingcart.service.impl;

import com.assignment.shoppingcart.model.User;
import com.assignment.shoppingcart.repository.UserRepository;
import com.assignment.shoppingcart.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * UserServiceImpl class that implements the UserService interface.
 * This class provides an implementation for all the methods that interact
 * with the database and contain business logic.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    /**
     * Method to find a user by email.
     *
     * @param email
     * @return
     */
    @Override
    public Optional<User> findByEmail(String email) {
        log.info("Inside UserServiceImpl -> findByEmail()", email);
        return userRepository.findByEmail(email);
    }

    /**
     * Method to save user into the database.
     *
     * @param user
     * @return
     */
    @Override
    public User save(User user) {
        log.info("Inside UserServiceImpl -> save()", user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}

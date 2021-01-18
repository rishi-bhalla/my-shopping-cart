package com.assignment.shoppingcart.service.impl;

import com.assignment.shoppingcart.model.User;
import com.assignment.shoppingcart.repository.UserRepository;
import com.assignment.shoppingcart.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    void findByEmail() {
        final String email = "test@test.com";
        Optional<User> user = Optional.of(new User());

        when(userRepository.findByEmail(anyString())).thenReturn(user);

        assertEquals(user, userServiceImpl.findByEmail(email));
    }

    private User buildUser() {
        User user = new User();
        user.setFirstName("first");
        user.setLastName("last");
        user.setEmail("test@test.com");
        user.setUsername("username");
        user.setPassword("password");
        return user;
    }

    @Test
    void save() {
        final User user = buildUser();

        when(userRepository.save(any())).thenReturn(user);

        assertEquals(user, userServiceImpl.save(user));
    }
}
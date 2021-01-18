package com.assignment.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * User class to represent the user entity in the database.
 * The class contains attributes annotated with validation annotations
 * to make sure a valid entity gets injected into the database.
 */
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @NotEmpty(message = "First name cannot be empty")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Please provide a valid email")
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "username", nullable = false, unique = true)
    @Length(min = 6, message = "Your username must have at least 6 characters")
    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @JsonIgnore
    @Length(min = 6, message = "Password must have at least 6 characters")
    @NotEmpty(message = "Password cannot be empty")
    @Column(name = "password", nullable = false)
    private String password;
}

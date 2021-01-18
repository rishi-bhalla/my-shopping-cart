package com.assignment.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * LoginController class to handle the login API.
 */
@Controller
public class LoginController {

    /**
     * API to handle the login flow of the user.
     * On successful authentication, user is taken to the home or the landing page
     * where the list of products are displayed.
     * If the login is unsuccessful, user will be redirected to the login page.
     *
     * @param principal
     * @return
     */
    @GetMapping("/login")
    public String login(Principal principal) {
        return principal != null ? "redirect:/home" : "/login";
    }
}

package com.assignment.shoppingcart.controller;

import com.assignment.shoppingcart.model.User;
import com.assignment.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * RegistrationController class to handle the registration of a new user.
 *
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    /**
     * API to get the registration page.
     * @return
     */
    @GetMapping("/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("/registration");
        return modelAndView;
    }

    /**
     * API to handle the registration of a new user.
     * This API will perform the necessary validation on the incoming data
     * and return the desired output to the user in case the desired criteria is not met.
     * In case of valid input data, the user is stored in to the database.
     *
     * @param user
     * @param bindingResult
     * @return
     */
    @PostMapping("/registration")
    public ModelAndView registerNewUser(@Valid User user, BindingResult bindingResult) {
        if(userService.findByEmail(user.getEmail()).isPresent())
            bindingResult.rejectValue("email", "error.user",
                    "User with the provided email already exists. Please choose a different email.");

        ModelAndView modelAndView = new ModelAndView();

        if(bindingResult.hasErrors())
            modelAndView.setViewName("/registration");
        else {
            // new user created
            userService.save(user);
            modelAndView.addObject("successMessage", "User created successfully.");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("/registration");
        }

        return modelAndView;
    }
}

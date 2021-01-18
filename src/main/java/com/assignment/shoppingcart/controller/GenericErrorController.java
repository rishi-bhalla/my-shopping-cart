package com.assignment.shoppingcart.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * GenericErrorController class to redirect to the correct page
 * in case of an error and a forbidden page that cannot be accessed.
 */
@Controller
public class GenericErrorController implements ErrorController {

    /**
     * Method to return the error page view.
     *
     * @return
     */
    @RequestMapping("/error")
    public ModelAndView error() {
        return new ModelAndView("/error");
    }

    /**
     * Method to return the forbidden page view.
     *
     * @return
     */
    @GetMapping("/403")
    public ModelAndView error403() {
        return new ModelAndView("/403");
    }

    /**
     * Method to return the error path.
     *
     * @return
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }
}

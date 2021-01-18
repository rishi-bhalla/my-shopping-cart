package com.assignment.shoppingcart.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * GlobalExceptionHandler class representing a global exception handler
 * for all the controller in the application.
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleGenericException(HttpServletRequest req, Exception ex) {
        log.error("Inside GlobalExceptionHandler -> handleGenericException", ex);
        ModelAndView modelAndView = new ModelAndView("/error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }
}

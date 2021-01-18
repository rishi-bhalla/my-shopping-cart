package com.assignment.shoppingcart.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GenericErrorControllerTest {

    @InjectMocks
    private GenericErrorController genericErrorController;

    @Test
    void error() {
        final ModelAndView modelAndView = new ModelAndView("/error");
        assertEquals(modelAndView.getView(), genericErrorController.error().getView());
    }

    @Test
    void error403() {
        final ModelAndView modelAndView = new ModelAndView("/403");
        assertEquals(modelAndView.getView(), genericErrorController.error403().getView());
    }

    @Test
    void getErrorPath() {
        assertEquals("/error", genericErrorController.getErrorPath());
    }
}
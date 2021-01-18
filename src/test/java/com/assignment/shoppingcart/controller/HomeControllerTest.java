package com.assignment.shoppingcart.controller;

import com.assignment.shoppingcart.model.Product;
import com.assignment.shoppingcart.repository.ProductRepository;
import com.assignment.shoppingcart.service.ProductService;
import com.assignment.shoppingcart.util.Pager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HomeControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private HomeController homeController;

    @Test
    void landingPage() {
        final Page<Product> productPage = new PageImpl<>(new ArrayList<>());
        final Pager pager = new Pager(productPage);
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pager", pager);
        modelAndView.addObject("products", productPage);
        modelAndView.setViewName("/home");

        when(productService.findAllProductsPageable(any())).thenReturn(productPage);

        assertEquals(modelAndView.getView(), homeController.landingPage(Optional.of(1)).getView());
    }
}
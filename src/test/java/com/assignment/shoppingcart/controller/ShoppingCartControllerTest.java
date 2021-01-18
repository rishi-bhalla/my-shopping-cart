package com.assignment.shoppingcart.controller;

import com.assignment.shoppingcart.model.Product;
import com.assignment.shoppingcart.service.ProductService;
import com.assignment.shoppingcart.service.ShoppingCartService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShoppingCartControllerTest {

    @Mock
    private ShoppingCartService shoppingCartService;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ShoppingCartController shoppingCartController;

    @Test
    void shoppingCart() {
        final Map<Product, Integer> products = new HashMap<>();
        final BigDecimal total = new BigDecimal(100);
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/shoppingCart");

        when(shoppingCartService.getProductsInCart()).thenReturn(products);
        when(shoppingCartService.getTotal()).thenReturn(total);

        assertEquals(modelAndView.getView(), shoppingCartController.shoppingCart().getView());
    }

    @Test
    void addProductToCart() {
        final Long productId = 1L;
        final Product product = new Product();
        product.setId(productId);
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/shoppingCart");

        when(productService.findById(anyLong())).thenReturn(Optional.of(product));

        assertEquals(modelAndView.getView(), shoppingCartController.addProductToCart(productId).getView());
    }

    @Test
    void removeProductFromCart() {
        final Long productId = 1L;
        final Product product = new Product();
        product.setId(productId);
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/shoppingCart");

        when(productService.findById(anyLong())).thenReturn(Optional.of(product));

        assertEquals(modelAndView.getView(), shoppingCartController.removeProductFromCart(productId).getView());
    }

    @Test
    void checkout() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/checkout");

        assertEquals(modelAndView.getView(), shoppingCartController.checkout().getView());
    }
}
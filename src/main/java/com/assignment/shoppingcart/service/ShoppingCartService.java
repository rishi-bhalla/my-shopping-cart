package com.assignment.shoppingcart.service;

import com.assignment.shoppingcart.model.Product;

import java.math.BigDecimal;
import java.util.Map;

/**
 * ShoppingCartService that specifies the contract that the implementing class must abide by.
 * All the classes implementing this interface must provide an implementation for the methods declared
 * in this interface.
 */
public interface ShoppingCartService {

    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    BigDecimal getTotal();

    void checkout();

}

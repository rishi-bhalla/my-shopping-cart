package com.assignment.shoppingcart.service.impl;

import com.assignment.shoppingcart.model.Product;
import com.assignment.shoppingcart.repository.ProductRepository;
import com.assignment.shoppingcart.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ShoppingCartServiceImpl class that implements the ShoppingCartService interface.
 * This class provides an implementation for all the methods that interact
 * with the database and contain business logic.
 */
@Slf4j
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private Map<Product, Integer> products = new HashMap<>();

    /**
     * Method to add a product to the shopping cart.
     *
     * @param product
     */
    @Override
    public void addProduct(Product product) {
        log.info("Inside ShoppingCartServiceImpl -> addProduct()", product.getId());
        if(products.containsKey(product))
            products.replace(product, products.get(product) + 1);
        else
            products.put(product, 1);
    }

    /**
     * Method to remove a product from the shopping cart.
     *
     * @param product
     */
    @Override
    public void removeProduct(Product product) {
        log.info("Inside ShoppingCartServiceImpl -> removeProduct()", product.getId());
        if(products.containsKey(product)) {
            if(products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else
                products.remove(product);
        }
    }

    /**
     * Method to get all the products currently present in the shopping cart.
     *
     * @return
     */
    @Override
    public Map<Product, Integer> getProductsInCart() {
        log.info("Inside ShoppingCartServiceImpl -> getProductsInCart()");
        return Collections.unmodifiableMap(products);
    }

    /**
     * Method to calculate the total price of all the products
     * currently present in the shopping cart.
     *
     * @return
     */
    @Override
    public BigDecimal getTotal() {
        log.info("Inside ShoppingCartServiceImpl -> getTotal()");
        return products.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Method to perform the final checkout while placing an order for the user.
     * This method will clear the shopping cart as the order has been placed to allow
     * user to add more items for the next order.
     *
     */
    @Override
    public void checkout() {
        log.info("Inside ShoppingCartServiceImpl -> checkout()");
        products.clear();
    }
}

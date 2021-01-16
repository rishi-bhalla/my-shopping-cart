package com.assignment.shoppingcart.service.impl;

import com.assignment.shoppingcart.model.Product;
import com.assignment.shoppingcart.repository.ProductRepository;
import com.assignment.shoppingcart.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

@Slf4j
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ProductRepository productRepository;

    private Map<Product, Integer> products;

    @Override
    public void addProduct(Product product) {
        if(products.containsKey(product))
            products.replace(product, products.get(product) + 1);
        else
            products.put(product, 1);
    }

    @Override
    public void removeProduct(Product product) {
        if(products.containsKey(product)) {
            if(products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else
                products.remove(product);
        }
    }

    @Override
    public Map<Product, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(products);
    }

    @Override
    public BigDecimal getTotal() {
        return products.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

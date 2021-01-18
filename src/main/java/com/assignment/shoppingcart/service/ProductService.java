package com.assignment.shoppingcart.service;

import com.assignment.shoppingcart.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * ProductService that specifies the contract associated with the product entity that the implementing
 * class must abide by.
 * All the classes implementing this interface must provide an implementation for the methods declared
 * in this interface.
 */
public interface ProductService {

    Optional<Product> findById(Long id);

    Page<Product> findAllProductsPageable(Pageable pageable);
}

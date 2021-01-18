package com.assignment.shoppingcart.service.impl;

import com.assignment.shoppingcart.model.Product;
import com.assignment.shoppingcart.repository.ProductRepository;
import com.assignment.shoppingcart.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ProductServiceImpl class that implements the ProductService interface.
 * This class provides an implementation for all the methods that interact
 * with the database and contain business logic.
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Method to find a product by id.
     *
     * @param id
     * @return
     */
    @Override
    public Optional<Product> findById(Long id) {
        log.info("Inside ProductServiceImpl -> findById()", id);
        return productRepository.findById(id);
    }

    /**
     * Method to display all the existing products on the home or
     * the landing page.
     * This method implements pagination to make sure a limited
     * number of items are displayed at a time.
     *
     * @param pageable
     * @return
     */
    @Override
    public Page<Product> findAllProductsPageable(Pageable pageable) {
        log.info("Indie ProductServiceImpl -> findAllProductsPageable()");
        return productRepository.findAll(pageable);
    }
}

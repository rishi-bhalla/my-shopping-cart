package com.assignment.shoppingcart.service.impl;

import com.assignment.shoppingcart.model.Product;
import com.assignment.shoppingcart.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Test
    void findById() {
        final Long productId = 1L;
        Product product = new Product();
        product.setId(productId);
        final Optional<Product> productOptional = Optional.of(product);

        when(productRepository.findById(anyLong())).thenReturn(productOptional);

        assertEquals(productOptional, productServiceImpl.findById(productId));
    }

    @Test
    void findAllProductsPageable() {
        final Pageable pageable = PageRequest.of(1, 5);
        final Page<Product> productPage = new PageImpl<>(new ArrayList<>());

        when(productRepository.findAll(any(Pageable.class))).thenReturn(productPage);

        assertEquals(productPage, productServiceImpl.findAllProductsPageable(pageable));
    }
}
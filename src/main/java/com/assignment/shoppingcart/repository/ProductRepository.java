package com.assignment.shoppingcart.repository;

import com.assignment.shoppingcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProductRepository that interacts with the database for the CRUD operations for product entity.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

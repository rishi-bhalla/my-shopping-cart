package com.assignment.shoppingcart.model;

import lombok.CustomLog;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

/**
 * Product class to represent the product entity in the database.
 * The class contains attributes annotated with validation annotations
 * to make sure a valid entity gets injected into the database.
 */
@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Min(value = 0, message = "Price of the product cannot be negative")
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Min(value = 0, message = "Quantity of the product cannot be negative")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}

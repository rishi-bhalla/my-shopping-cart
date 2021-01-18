package com.assignment.shoppingcart.controller;

import com.assignment.shoppingcart.service.ProductService;
import com.assignment.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * ShoppingCartController class to handle the API's related the shopping cart.
 *
 */
@Controller
public class ShoppingCartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * API to return all the products currently present in the shopping cart
     * along with the total cart price.
     *
     * @return
     */
    @GetMapping("/shoppingCart")
    public ModelAndView shoppingCart() {
        ModelAndView modelAndView = new ModelAndView("/shoppingCart");
        modelAndView.addObject("products", shoppingCartService.getProductsInCart());
        modelAndView.addObject("total", shoppingCartService.getTotal());
        return modelAndView;
    }

    /**
     * API to add a product to the cart and return all the products
     * currently present in the cart.
     *
     * @param productId
     * @return
     */
    @GetMapping("/shoppingCart/addProduct/{productId}")
    public ModelAndView addProductToCart(@PathVariable("productId") Long productId) {
        productService.findById(productId).ifPresent(shoppingCartService::addProduct);
        return shoppingCart();
    }

    /**
     * API to remove a product from the cart and return all the products
     * currently present in the cart.
     *
     * @param productId
     * @return
     */
    @GetMapping("/shoppingCart/removeProduct/{productId}")
    public ModelAndView removeProductFromCart(@PathVariable("productId") Long productId) {
        productService.findById(productId).ifPresent(shoppingCartService::removeProduct);
        return shoppingCart();
    }

    /**
     * API to perform a final checkout while placing an order for a user.
     * After the order is placed, this API clears all the items from the cart
     * that were previously present so that the user can start to add the items again.
     *
     * @return
     */
    @GetMapping("/shoppingCart/checkout")
    public ModelAndView checkout() {
        ModelAndView modelAndView = new ModelAndView();
        shoppingCartService.checkout();
        modelAndView.setViewName("/checkout");
        return modelAndView;
    }
}

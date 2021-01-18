package com.assignment.shoppingcart.controller;

import com.assignment.shoppingcart.model.Product;
import com.assignment.shoppingcart.service.ProductService;
import com.assignment.shoppingcart.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * HomeController class to handle the API's for the landing or the home page
 * that displays all the currently available products.
 */
@Controller
public class HomeController {

    private static final int INITIAL_PAGE = 0;

    @Autowired
    private ProductService productService;

    /**
     * API to return all the currently available products.
     * This API also implements pagination to help UI display
     * products across multiple pages to give a better user experience.
     *
     * @param page
     * @return
     */
    @GetMapping("/home")
    public ModelAndView landingPage(@RequestParam("page") Optional<Integer> page) {
        int currentPage = page.orElse(0) < 1 ? INITIAL_PAGE : page.get() - 1;

        Page<Product> products = productService.findAllProductsPageable(PageRequest.of(currentPage, 5));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pager", new Pager(products));
        modelAndView.addObject("products", products);
        modelAndView.setViewName("/home");
        return modelAndView;
    }
}

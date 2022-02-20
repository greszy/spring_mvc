package com.test.hplus.controllers;

import com.test.hplus.beans.Product;
import com.test.hplus.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private ProductRepository productRepository;

    //This controller handles the search request
    @GetMapping("/search")
    /*
    When using a @RequestParam("search") in a controller, we expect to extract from the request a parameter which name is equal to "search".
     */
    public String search(@RequestParam("search") String search, Model model) {
        System.out.println("in search controller");
        System.out.println("search criteria: " + search);

        List<Product> products = new ArrayList<>();
        products = productRepository.searchByName(search);
        //Here the products list retrieved from the database is assigned to a model as a key-value pair. These attributes can later be accessed on the jsp pages.
        model.addAttribute("products", products);
        return "search";
    }

}

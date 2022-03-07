package com.test.hplus.restcontrollers;

import com.test.hplus.beans.Product;
import com.test.hplus.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RestController signifies that a class is a restful service class. With this annotation @ResponseBody is not needed.
@RestController
public class ProductsRestController {

    @Autowired
    ProductRepository productRepository;

//    //Alternatively the @RequestMapping annotation can be used define mappings.
//    @GetMapping("/hplus/rest/products")
//    //Thanks to the @ResponseBody annotation the return type of the controller method will be converted into a JSON representation.
//    @ResponseBody
//    public List<Product> getProducts() {
//        //call product repo.
//        List<Product> products = new ArrayList<>();
//        //The default repository method findAll() returns an Iterable of products.
//        productRepository.findAll().forEach(product -> products.add(product));
//        return products;
//    }

    @GetMapping("/hplus/rest/products")
    public ResponseEntity getProductsByRequestParam(@RequestParam("name") String name) {
        List<Product> products = productRepository.searchByName(name);
        //ResponseEntity is an object that allows sending back information back to the client about the request.
        return new ResponseEntity(products, HttpStatus.OK);
    }
    //The {name} represents a path variable.
    @GetMapping("/hplus/rest/products/{name}")
    public ResponseEntity getProductByPathVariable(@PathVariable("name") String name) {
        List<Product> products = productRepository.searchByName(name);
        return new ResponseEntity(products, HttpStatus.OK);
    }

}

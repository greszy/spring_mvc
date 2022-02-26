package com.test.hplus.controllers;

import com.test.hplus.beans.Product;
import com.test.hplus.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@Controller
public class SearchController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AsyncTaskExecutor executor;

    //This controller handles the search request
    @GetMapping("/search")
    /*
    When using a @RequestParam("search") in a controller, we expect to extract from the request a parameter which name is equal to "search".
     */
    public DeferredResult<String> search(@RequestParam("search") String search, Model model, HttpServletRequest request) {
        DeferredResult<String> deferredResult = new DeferredResult<>();
        System.out.println("in search controller");
        System.out.println("search criteria: " + search);
        //Here we are checking if the flag for async processing support is true.
        System.out.println("Async supported in this application: " + request.isAsyncSupported());
        System.out.println("Thread from the servlet container: " + Thread.currentThread().getName());

//        return () -> {
//            //This time is set to simulate the delay of a blocking call.
//            Thread.sleep(3000);
//            System.out.println("Thread from spring mvc task executor: " + Thread.currentThread().getName());
//            List<Product> products = new ArrayList<>();
//            products = productRepository.searchByName(search);
//            //Here the products list retrieved from the database is assigned to a model as a key-value pair. These attributes can later be accessed on the jsp pages.
//            model.addAttribute("products", products);
//            return "search";
//        };

        executor.execute(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread from spring mvc task executor: " + Thread.currentThread().getName());
            List<Product> products;
            products = productRepository.searchByName(search);
            //Here the products list retrieved from the database is assigned to a model as a key-value pair. These attributes can later be accessed on the jsp pages.
            model.addAttribute("products", products);
            deferredResult.setResult("search");
        });
        return deferredResult;
    }
}

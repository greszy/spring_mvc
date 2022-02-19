package com.test.hplus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    //This controller handles the search request
    @GetMapping("/search")
    /*
    When using a @RequestParam("search") in a controller, we expect to extract from the request a parameter which name is equal to "search".
     */
    public String search(@RequestParam("search") String search, Model model) {
        System.out.println("in search controller");
        System.out.println("search criteria: " + search);
        return "search";
    }

}

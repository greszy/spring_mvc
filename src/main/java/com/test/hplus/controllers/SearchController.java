package com.test.hplus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
    //This controller handles the search request
    @GetMapping("/search")
    public String search() {
        System.out.println("in search controller");
        return "search";
    }

}

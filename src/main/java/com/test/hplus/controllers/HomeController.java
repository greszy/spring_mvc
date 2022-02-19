package com.test.hplus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //@GetMapping is one of the annotations that allows us to define the url patterns in the controller.
    @GetMapping("/home")
    public String goHome() {
        System.out.println("in home controller");
        //"index" is the name of the view.
        return "index";
    }
}

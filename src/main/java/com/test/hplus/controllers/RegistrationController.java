package com.test.hplus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    //Since the form holds user sensitive information, we should be using PostMapping instead of GetMapping for the registration form submission.
    @PostMapping("/registeruser")
    public String registerUser() {
        System.out.println("in registration controller");
        return "login";
    }
}

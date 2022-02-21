package com.test.hplus.controllers;

import com.test.hplus.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    //Since the form holds user sensitive information, we should be using PostMapping instead of GetMapping for the registration form submission.
    @PostMapping("/registeruser")
    //@ModelAttribute is used to bond the "newUser" attribute to a User object.
    public String registerUser(@ModelAttribute("newUser") User user) {
        System.out.println("in registration controller");
        return "login";
    }
}

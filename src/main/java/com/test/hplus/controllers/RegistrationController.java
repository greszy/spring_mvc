package com.test.hplus.controllers;

import com.test.hplus.beans.User;
import com.test.hplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    //Since the form holds user sensitive information, we should be using PostMapping instead of GetMapping for the registration form submission.
    @PostMapping("/registeruser")
    //@ModelAttribute is used to bond the "newUser" attribute to a User object.
    //@Valid signals to Spring MVC that javax validation has been used inside the User bean.
    //BindingResult parameter will be populated with the validation error messages.
    public String registerUser(@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model) {
        System.out.println("in registration controller");

        if (result.hasErrors()) {
            return "register";
        }
        userRepository.save(user);
        model.addAttribute("dataSaved", "User registered successfully");
        return "login";
    }
}

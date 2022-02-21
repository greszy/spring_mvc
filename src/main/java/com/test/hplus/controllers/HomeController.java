package com.test.hplus.controllers;

import com.test.hplus.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    //@GetMapping is one of the annotations that allows us to define the url patterns in the controller.
    @GetMapping("/home")
    public String goHome() {
        System.out.println("in home controller");
        //"index" is the name of the view.
        return "index";
    }
    //This controller handles directing to the search page.
    @GetMapping("/goToSearch")
    public String goToSearch(){
        System.out.println("Going to search page.");
        return "search";
    }
    //This controller handles directing to the login page.
    @GetMapping("/goToLogin")
    public String goToLogin(){
        System.out.println("Going to login page.");
        return "login";
    }
    //This controller handles directing to the register page.
    @GetMapping("/goToRegistration")
    public String goToRegistration(){
        System.out.println("Going to register page.");
        return "register";
    }

    //The register jsp page won't be able to render properly without this default object, because the modelAttribute in the form requires an object to be assigned to it.
    @ModelAttribute("newUser")
    public User getDefaultUser() {
        return new User();
    }

    @ModelAttribute("genderItems")
    public List<String> getGenderItems() {
        return Arrays.asList(new String[]{"Male", "Female", "Other"});
    }
}

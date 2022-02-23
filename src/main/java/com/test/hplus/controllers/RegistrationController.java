package com.test.hplus.controllers;

import com.test.hplus.beans.User;
import com.test.hplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    //@InitBinder is used to convert strings into objects by the use of an editor.
    //The property editors are registered on the WebDataBinder instance that is passed as a parameter.
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //To use an editor we have to call the registerCustomEditor method.
        /*
        The registerCustomEditor accepts as arguments the datatype you want the string value to be converted to.
        Secondly it will demand the name of the field from the form that you want to convert.
        The last parameter is an editor object that you will want to use to convert the field.
         */
        binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(new SimpleDateFormat("yyy-MM-dd"), true));
    }

    //Since the form holds user sensitive information, we should be using PostMapping instead of GetMapping for the registration form submission.
    @PostMapping("/registeruser")
    //@ModelAttribute is used to bond the "newUser" attribute to a User object.
    //@Valid signals to Spring MVC that javax validation has been used inside the User bean.
    //BindingResult parameter will be populated with the validation error messages.
    public String registerUser(@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model) {
        System.out.println("in registration controller");
        System.out.println(user.getDateOfBirth());
        if (result.hasErrors()) {
            return "register";
        }
        userRepository.save(user);
        model.addAttribute("dataSaved", "User registered successfully");
        return "login";
    }
}

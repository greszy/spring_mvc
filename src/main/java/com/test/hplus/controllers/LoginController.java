package com.test.hplus.controllers;

import com.test.hplus.beans.Login;
import com.test.hplus.beans.User;
import com.test.hplus.exceptions.ApplicationException;
import com.test.hplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@SessionAttribute allows storage of the session attribute, in this case the name of the attribute is "login".
@SessionAttributes("login")
public class LoginController {

    @Autowired
    UserRepository userRepository;

    //A login model attribute does not to be declared in this controller, thanks to the DefaultModelAttributeController.
//    @ModelAttribute("login")
//    public Login getDefaultLogin() {
//        return new Login();
//    }

    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login) {
        User user = userRepository.searchByName(login.getUsername());
        if (user==null){
            throw new ApplicationException("User not found!");
        }
        //return "search";
        //Now instead of directing to the search page, with the use of forwarding, the login controller forwards to the user profile controller.
        return "forward:/userprofile";
    }
    //Whenever an exception occurs in Login Controller the handleException will be called.
    //By embedding the name of the exception class in the @ExceptionHandler annotation we make sure the method will handle exceptions with that specific name.
//    @ExceptionHandler(ApplicationException.class)
//    public String handleException() {
//        System.out.println("in exception handler of Login Controller");
//        return "error";
//    }

}

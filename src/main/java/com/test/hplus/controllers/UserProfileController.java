package com.test.hplus.controllers;

import com.test.hplus.beans.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserProfileController {

    @PostMapping("/userprofile")
    //@SessionAttribute allows retrieval of the session attribute from the LoginController
    public String getsUserProfile(@SessionAttribute("login") Login login) {
        System.out.println("in user profile controller");
        return "profile";
    }

}

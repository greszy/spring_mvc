package com.test.hplus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        System.out.println("Ending user session");
        session.invalidate();
        //This line below should not work, since the session was ended by the invalidate method.
        //System.out.println(session.getAttribute("login"));
        return "login";
    }
}

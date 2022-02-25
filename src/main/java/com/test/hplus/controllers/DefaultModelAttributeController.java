package com.test.hplus.controllers;

import com.test.hplus.beans.Login;
import com.test.hplus.beans.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

//This @ControllerAdvice makes sure that no matter what controller flow executes, all of them will have the default models available.
@ControllerAdvice
public class DefaultModelAttributeController {

    //The register jsp page won't be able to render properly without this default object, because the modelAttribute in the form requires an object to be assigned to it.
    @ModelAttribute("newUser")
    public User getDefaultUser() {
        return new User();
    }

    @ModelAttribute("genderItems")
    public List<String> getGenderItems() {
        return Arrays.asList(new String[]{"Male", "Female", "Other"});
    }

    @ModelAttribute("login")
    public Login getDefaultLogin() {
        return new Login();
    }
}

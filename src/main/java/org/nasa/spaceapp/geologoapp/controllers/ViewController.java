package org.nasa.spaceapp.geologoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/tutorial")
    public String showTutorial() {
        return "tutorial";
    }

    @GetMapping("/blog")
    public String showBlog() {
        return "blog";
    }

    @GetMapping("/profile")
    public String showProfile() {
        return "profile";
    }

    @GetMapping("/home")
    public String showHome() {
        return "home";
    }
}

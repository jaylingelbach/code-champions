package com.codechampions.easytravel.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    // Corresponds to http://localhost:8080
    @GetMapping("/")
    public String redirectToHomePage() {
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String displayHomePage(Model model, HttpSession session) {
        model.addAttribute("headingText", "Welcome");
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        return "index";
    }

}

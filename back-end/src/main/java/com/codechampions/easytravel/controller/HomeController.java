package com.codechampions.easytravel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToHomePage() {
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String displayHomePage() {
        return "index";
    }

}
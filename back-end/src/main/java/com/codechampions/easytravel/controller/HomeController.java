package com.codechampions.easytravel.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")
    public String redirectToHomePage() {
        return "redirect:/welcome";
    }

}

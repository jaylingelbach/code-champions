package com.codechampions.easytravel.controller;

import com.codechampions.easytravel.model.UserProfile;
import com.codechampions.easytravel.repository.UserProfileRepository;
import com.codechampions.easytravel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/profile")
public class UserController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public String viewProfile(@PathVariable Integer id, Model model) {
        Optional<UserProfile> userProfile = UserProfileRepository.findById(id);
        model.addAttribute("userProfile",userProfile);
        return "profile/view";
    }

    @GetMapping("/edit/{id}")
    public String editProfile(@PathVariable Integer id, Model model) {
        Optional<UserProfile> userProfileOptional = userProfileRepository.findById(id);
        model.addAttribute("userProfile", userProfile);
        return "profile/edit";
    }


    @PostMapping("/edit/{id}")
    public String updateProfile(@PathVariable Integer id, Model model) {
        Optional<UserProfile> userProfileOptional = userProfileRepository.findById(id);
        model.addAttribute("userProfile", userProfile);
        userProfileRepository.save(userProfile);
        return "redirect:/profile/" + id;
    }
}
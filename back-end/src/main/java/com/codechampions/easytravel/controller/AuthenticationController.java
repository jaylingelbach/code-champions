package com.codechampions.easytravel.controller;

import com.codechampions.easytravel.model.User;
import com.codechampions.easytravel.model.dto.RegistrationFormDTO;
import com.codechampions.easytravel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {

        model.addAttribute(new RegistrationFormDTO());

        return "registration_form";
    }

    @PostMapping("/register")
    public String processRegister(RegistrationFormDTO registrationFormDTO){

        User newUser = new User(
                registrationFormDTO.getUsername(),
                registrationFormDTO.getPassword()
        );

        userRepository.save(newUser);
        return "register_success";
    }
}
package com.codechampions.easytravel.controller;

import com.codechampions.easytravel.model.User;
import com.codechampions.easytravel.model.UserProfile;
import com.codechampions.easytravel.model.dto.UserProfileDTO;
import com.codechampions.easytravel.repository.ProfileRepository;
import com.codechampions.easytravel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    private static final String userSessionKey = "user";

    @GetMapping("")
    public String displayProfileForm (Model model, HttpSession session) {

        Integer userId = (Integer) session.getAttribute(userSessionKey);

        Optional<User> userOpt = userRepository.findById(userId);
        UserProfile userProfile = profileRepository.findByUserId(userId);

        UserProfileDTO userProfileDTO = new UserProfileDTO();

        if (userProfile != null) {
            userProfileDTO.setFirstName(userProfile.getFirstName());
        }

        model.addAttribute("username", userOpt.get().getUsername());
        model.addAttribute("userProfileDTO", userProfileDTO);

        return "profile/view";
    }

}
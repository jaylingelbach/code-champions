package com.codechampions.easytravel.controller;

import com.codechampions.easytravel.model.Activity;
import com.codechampions.easytravel.repository.ActivityRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ActivitiesController {

    @Autowired
    private ActivityRepository activityRepository;


    @PostMapping("/activity")
    public String handleFormSubmission(@ModelAttribute("newActivity") Activity newActivity, Model model) {
        activityRepository.save(newActivity);
        return "redirect:/activities";
    }
    @GetMapping("/activities")
    public String getActivities(Model model, HttpSession session) {
        List<Activity> activities = activityRepository.findAll();

        model.addAttribute("activities", activities);

        return "activities/main";
    }

    @GetMapping("/newactivity")
    public String addActivities(Model model, HttpSession session) {
        model.addAttribute("newActivity", new Activity());
        return "activities/new_activity";
    }
}
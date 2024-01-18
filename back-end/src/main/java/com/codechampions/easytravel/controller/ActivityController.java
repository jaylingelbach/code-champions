package com.codechampions.easytravel.controller;

import com.codechampions.easytravel.model.ActivityType;
import com.codechampions.easytravel.model.Operator;
import com.codechampions.easytravel.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.codechampions.easytravel.model.Activity;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private OperatorRepository operatorRepository;

    @Autowired
    private ActivityTypeRepository activityTypeRepository;

    @Autowired
    private UserRepository userRepository;

    private static final String userSessionKey = "user";

    @GetMapping("")
    public String displayActivities(@RequestParam(required = false) Integer operatorId, @RequestParam(required = false) Integer activityTypeId, Model model) {
        if (operatorId != null) {
            Optional<Operator> operatorOptional = operatorRepository.findById(operatorId);
            if (operatorOptional.isPresent()) {
                Operator operator = operatorOptional.get();
                model.addAttribute("activities", operator.getActivities());
            }
        } else if (activityTypeId != null) {
            Optional<ActivityType> activityTypeOptional = activityTypeRepository.findById(activityTypeId);
            if (activityTypeOptional.isPresent()) {
                ActivityType activityType = activityTypeOptional.get();
                model.addAttribute("activities", activityType.getActivities());
            }
        } else {
            model.addAttribute("activities", activityRepository.findAll());
        }
        return "activities/index";
    }

    @GetMapping("/add")
    public String displayAddActivityForm(Model model) {
        Activity newActivity = new Activity();
        List<Operator> operators = operatorRepository.findAll();
        List<ActivityType> activityTypes = activityTypeRepository.findAll();
        model.addAttribute("activity", newActivity);
        model.addAttribute("activityTypes", activityTypes);
        model.addAttribute("operators", operators);

        return "activities/add";
    }

}

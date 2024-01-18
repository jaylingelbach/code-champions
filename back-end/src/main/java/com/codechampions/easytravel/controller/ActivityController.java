package com.codechampions.easytravel.controller;

import com.codechampions.easytravel.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.codechampions.easytravel.model.Activity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @PostMapping("/activity")
    Activity newActivity(@RequestBody Activity newActivity){
        return activityRepository.save(newActivity);
    }
    @GetMapping("/activities")
    List<Activity> getAllActivities(){
        return activityRepository.findAll();
    }
}

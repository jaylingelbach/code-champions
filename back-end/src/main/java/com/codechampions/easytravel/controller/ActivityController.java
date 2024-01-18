package com.codechampions.easytravel.controller;

import org.springframework.stereotype.Controller;
import com.codechampions.easytravel.repository.ActivityRepository;
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
    private ActivityRepository activityRepository;

    @PostMapping("/activity")
    Activity newActivity(@RequestBody Activity newActivity){
        return activityRepository.save(newActivity);
    }
    @GetMapping("/activities")
    List<Activity> getAllActivities(){
        return activityRepository.findAll();
    }
}

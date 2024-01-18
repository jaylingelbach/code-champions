package com.codechampions.easytravel.controller;

import com.codechampions.easytravel.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.codechampions.easytravel.model.Activity;
import java.util.List;

@Controller
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

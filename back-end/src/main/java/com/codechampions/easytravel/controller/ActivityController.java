package com.codechampions.easytravel.controller;

import com.codechampions.easytravel.model.*;
import com.codechampions.easytravel.repository.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public String processAddActivity(@ModelAttribute @Valid Activity newActivity, @RequestParam(required = false) List<Integer> operatorIds, @RequestParam(required = false) List<Integer> activityTypeIds, Errors errors, Model model) {
        if(errors.hasErrors()) {
            System.out.println(errors.getAllErrors());
            List<Operator> allOperators = operatorRepository.findAll();
            List<ActivityType> allActivityTypes = activityTypeRepository.findAll();

            model.addAttribute("operators", allOperators);
            model.addAttribute("activityTypes", allActivityTypes);

            return "activities/add";
        } else {
            if (operatorIds != null && activityTypeIds != null) {
                List<Operator> selectedOperator = operatorRepository.findAllById(operatorIds);
                List<ActivityType> selectedActivityType = activityTypeRepository.findAllById(activityTypeIds);
                newActivity.setOperators(selectedOperator);
                newActivity.setActivityTypes(selectedActivityType);
            }
        }
        activityRepository.save(newActivity);
        return "redirect:/activities";
    }

    @GetMapping("/details/{activityId}")
    public String displayActivityDetailsPage(@PathVariable int activityId, Model model) {
        Optional<Activity> result = activityRepository.findById(activityId);
        if (result.isPresent()) {
            Activity activity= result.get();
            List<Comment> comments = commentRepository.findAll();
            Comment newComment = new Comment();
            model.addAttribute("comments", comments);
            model.addAttribute("newComment", newComment);
            model.addAttribute("activity", activity);
            return "activities/details";
        } else {
            return "activities/index";
        }
    }

    @PostMapping("/details/{activityId}")
    public String addCommentToDetails(@ModelAttribute Comment newComment, HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        Optional<User> userOpt = userRepository.findById(userId);

        if( userOpt.isPresent()) {
            newComment.setUser(userOpt.get());
            commentRepository.save(newComment);
        }

        return "redirect:/activities/details/{activityId}";
    }

}

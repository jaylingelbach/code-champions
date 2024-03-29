package com.codechampions.easytravel.controller;

import com.codechampions.easytravel.model.Comment;
import com.codechampions.easytravel.model.User;
import com.codechampions.easytravel.repository.ActivityRepository;
import com.codechampions.easytravel.repository.CommentRepository;
import com.codechampions.easytravel.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ActivityRepository activityRepository;

    private static final String userSessionKey = "user";

    @GetMapping("")
    public String showComment(Model model, HttpSession session) {
        List<Comment> comments = commentRepository.findAll();
        Comment newComment = new Comment();
        model.addAttribute("comments", comments);
        model.addAttribute("newComment", newComment);

        return "comments/commentshowpage";
    }

    @PostMapping("")
    public String addComment(@ModelAttribute Comment newComment, HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        Optional<User> userOpt = userRepository.findById(userId);

        if( userOpt.isPresent()) {
            newComment.setUser(userOpt.get());
            commentRepository.save(newComment);
        }
        return "redirect:/comments";
        }

}

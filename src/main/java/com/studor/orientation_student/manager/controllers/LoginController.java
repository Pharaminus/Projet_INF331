package com.studor.orientation_student.manager.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studor.orientation_student.entities.profilejobprediction.User;
import com.studor.orientation_student.manager.repositories.profilejobpredictrepository.UserRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/login")
public class LoginController {
    
    @GetMapping("/form")
    public String testForm() {
        return "test-form";
    }

    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/submit")
    public String sendTest(HttpSession session,
    @RequestParam("email") String email, @RequestParam("motDePasse") String password) 
    {
        User user = userRepository.findByEmail(email);
        
        if(user != null && user.getMotDePasse().equals(password)){
            String str, sessionId = UUID.randomUUID().toString();
            System.out.println("====================>>>>>>>>>>>>"+sessionId);
            session.setAttribute("email", email);
            session.setAttribute("sessionId", sessionId);
            str = (String)session.getAttribute("email");
            System.out.println("====================>>>>>>>>>>>>"+str);
            return "establishment-job-templates/profile-job-predicted";
        }
        else{
            return testForm();
        }
    }
}

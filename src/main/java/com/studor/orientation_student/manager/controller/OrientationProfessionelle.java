package com.studor.orientation_student.manager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.studor.orientation_student.entities.suggestionCourEntities.profilejobprediction.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/orientationprofessionelle")
public class OrientationProfessionelle {
    private HttpServletRequest request;

    @GetMapping("/acceuille")
    public String acceuille(HttpSession session){
        // HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
                System.out.println("((((((((({{{{{ZZZZ}}}}})))))))))"+user.getEmail());

        return "formOrientationProfessionnel";
    }
    
    @GetMapping("/test")
    public String test(){
        return "formExtractionText";
    }
}

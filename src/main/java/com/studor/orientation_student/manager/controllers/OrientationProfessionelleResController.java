package com.studor.orientation_student.manager.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orientationprofessionelleRest")
public class OrientationProfessionelleResController {
    
    @GetMapping("/acceuille")
    public String acceuille(){
        return "formOrientationProfessionnel";
    }
    
    
}

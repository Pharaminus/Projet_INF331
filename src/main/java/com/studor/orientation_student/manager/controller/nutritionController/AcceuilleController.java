package com.studor.orientation_student.manager.controller.nutritionController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AcceuilleController {
    
    @GetMapping("/nutrition")
    public String accueille()
    {
        return "nutrition/Restaurantly/index";
    }
}

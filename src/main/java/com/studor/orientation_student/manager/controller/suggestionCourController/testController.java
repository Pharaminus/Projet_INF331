package com.studor.orientation_student.manager.controller.suggestionCourController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {
    
    @GetMapping("test")
    public String test(){
        return "suggestionCour/test_form";
    }

    @GetMapping("test1")
    public String test1(){
        return "suggestionCour/test_form1";
    }
}

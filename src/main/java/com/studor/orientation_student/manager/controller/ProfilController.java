package com.studor.orientation_student.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.studor.orientation_student.entity.Profil;
import com.studor.orientation_student.manager.repository.ProfilRepository;

@Controller
@RequestMapping("/profil")
public class ProfilController {

    @Autowired
    private ProfilRepository profilRepo;

    @GetMapping("/form")
    public String page(){
        return "form-profil";
    }
    
    @PostMapping("/send")
    public String send(@ModelAttribute("profil") Profil profil, BindingResult result){
        profilRepo.save(profil);
        return "form-profil";
    }
}

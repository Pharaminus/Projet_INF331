package com.studor.orientation_student.manager.controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studor.orientation_student.manager.repository.ProfilRepository;

@RestController
@RequestMapping("/profil")
public class ProfilController {
    @Autowired
    private ProfilRepository profilRepository;
    @GetMapping("/form")
    public String page(){
        return "formProfil";
    }
    
    @PostMapping("/send")
    public String send_profil(){
        System.out.println("---------]>"+"profil.getNom()");
        // profilRepository.save(profil);
        
        return "acceuil";
    }

    @GetMapping("/test")
    public String test(){
        
        // Utilisateur utilisateur = new Utilisateur("Ruth" ,"Ruth.com", "ruht237");
        // System.out.println(utilisateur.getNom());
        return "utilisateur.getNom()";
    }

}

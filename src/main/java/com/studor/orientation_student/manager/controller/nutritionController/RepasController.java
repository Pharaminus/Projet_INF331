package com.studor.orientation_student.manager.controller.nutritionController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studor.orientation_student.entities.nutritionEntities.Repas;
import com.studor.orientation_student.manager.repository.nutritionRepository.RepasRepository;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/repas")
public class RepasController {
    
    @Autowired
    private RepasRepository repasRepository;

    @GetMapping("/AllFood")
    public String getMethodName(Model model) {
        List<Repas> allFood = repasRepository.findAll();
        if(allFood == null) {
            System.out.println("######(--- AUCUN Repas Trouve ---)#####");
            return "nutrition/error";
        }
        else
        {
            model.addAttribute("repas", allFood);
            return "nutrition/repas";
        }
    }

    @GetMapping("/from")
    public String getMethodName() {
        return "form";
    }
    

    @GetMapping("/rechercher-repas")
    public String rechercherRepas(@RequestParam("nom") String nom, @RequestParam("prix") double prix, Model model) {
        Repas repas = repasRepository.findByNomAndPrix(nom, prix);
        model.addAttribute("repas", repas);
        return "nutrition/repas";
    }
    
}

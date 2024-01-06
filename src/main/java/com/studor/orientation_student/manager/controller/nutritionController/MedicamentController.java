package com.studor.orientation_student.manager.controller.nutritionController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.studor.orientation_student.entities.nutritionEntities.Maladies;
import com.studor.orientation_student.manager.repository.nutritionRepository.MaladiesRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/medoc")
public class MedicamentController {
    
    @Autowired
    private MaladiesRepository maladiesRepository;

    @PostMapping("/medicament")
    public String getMaladie(Model model, @RequestParam("nom") String nom) {
    
        Maladies associatedMaladie = maladiesRepository.findByNom(nom);
        if(associatedMaladie == null)
        {
            System.out.println("----------------aucune maladie trouver en base de donne");
            return "erreur";
        }
        else{
            String medicaments = associatedMaladie.getMedicament();
            // Add the associated maladie to the model
            model.addAttribute("maladie", medicaments);
            
            // Return the name of the HTML template to render
            return "nutrition/medicament";
        }
    }
    @GetMapping("/affiche")
    public String getAllMaladies(Model model)
    {   
        List<Maladies> maladies = maladiesRepository.findAll();
        if (maladies == null){
            
            System.out.println("#########(--- aucune maladie en base de Donnee ---)########");
            return "error";
        }
        else
        {
            model.addAttribute("maladies", maladies);
            return "maladies";
        }
        
    }
}
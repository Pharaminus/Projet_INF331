package com.studor.orientation_student.manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studor.orientation_student.entities.establishmentsuggestion.Domain;
import com.studor.orientation_student.entities.establishmentsuggestion.Establishment;
import com.studor.orientation_student.entities.establishmentsuggestion.Training;
import com.studor.orientation_student.manager.repository.DomainRepository;
import com.studor.orientation_student.manager.repository.EstablishmentRepository;
import com.studor.orientation_student.manager.repository.TrainingRepository;

@Controller
@RequestMapping("/establishment")
public class EstablishmentSuggestionController {

    @Autowired
    private EstablishmentRepository establishmentRepository;

    @Autowired
    private DomainRepository domainRepository;

    @Autowired
    private TrainingRepository trainingRepository;

    @GetMapping("/test")
    public String testSearch(String search) {
        search = "Informatique";
        List<Establishment> establishmentsByLocation = establishmentRepository.findByLocalisation(search);
        Domain domainByName = domainRepository.findByNom(search);
        Training trainingByName = trainingRepository.findByNom(search);
        List<String> listEstablishment = new ArrayList<>();
        if (isConvertible(search) == true) {
            double prix = Double.parseDouble(search);
            trainingRepository.findByCout(prix);
            List<Training> trainingsByCost = trainingRepository.findByCout(prix);
            for (Training training : trainingsByCost) {
                listEstablishment.add(training.getEstablishment().getNom());
            }
            // model.addAttribute("result", trainingsByCost);
        } else {
            if (!establishmentsByLocation.isEmpty()) {
                System.out.println(establishmentsByLocation);
                for (Establishment establishment : establishmentsByLocation) {
                    listEstablishment.add(establishment.getNom());
                }
                System.out.println("=======================>>>>>>>>>>>> " + listEstablishment);
                // model.addAttribute("result", listEstablishment);
            } else if (domainByName != null) {
                String establishment = domainByName.getEstablishment().getNom();
                System.out.println("=======================>>>>>>>>>>>> " + establishment);
                // model.addAttribute("result", establishment);
            } else if (trainingByName != null) {
                String establishment = trainingByName.getEstablishment().getNom();
                System.out.println("=======================>>>>>>>>>>>> " + establishment);
                // model.addAttribute("result", establishment);
            }
        }

        return "establishment-suggestion";
    }

    @GetMapping("/search")
    public String searcEstablishment(@RequestParam("search") String search, Model model) {

        // Establishment establishmentsByName =
        // establishmentRepository.findByNom(search);
        List<Establishment> establishmentsByLocation = establishmentRepository.findByLocalisation(search);
        Domain domainByName = domainRepository.findByNom(search);
        Training trainingByName = trainingRepository.findByNom(search);
        List<String> listEstablishment = new ArrayList<>();
        if (isConvertible(search) == true) {
            double prix = Double.parseDouble(search);
            trainingRepository.findByCout(prix);
            List<Training> trainingsByCost = trainingRepository.findByCout(prix);
            for (Training training : trainingsByCost) {
                listEstablishment.add(training.getEstablishment().getNom());
            }
            model.addAttribute("result", trainingsByCost);
        } else {
            if (establishmentsByLocation != null) {
                for (Establishment establishment : establishmentsByLocation) {
                    listEstablishment.add(establishment.getNom());
                }
                model.addAttribute("result", listEstablishment);
            } else if (domainByName != null) {
                String establishment = domainByName.getEstablishment().getNom();
                model.addAttribute("result", establishment);
            } else if (trainingByName != null) {
                String establishment = trainingByName.getEstablishment().getNom();
                model.addAttribute("result", establishment);
            }
        }

        return "establishment-suggestion";
    }

    public static boolean isConvertible(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

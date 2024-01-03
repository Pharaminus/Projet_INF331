package com.studor.orientation_student.manager.service.nouriture;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.studor.orientation_student.entities.nutrition.Maladies;
import com.studor.orientation_student.entities.nutrition.Repas;

@Service
public class MaladiesService {

    // methode pour consulter un medicament d'urgence a une maladie
   

    // methode pour la prediction de repas
    public String predictMaladies(List<Repas> repasconsommes)
    {
        // charger les donnees de maladies depuis le fichier csv
        List<Maladies> maladies = loadMaladiesFromCSV("donnees.csv"); 

        // effectue la prediction en fonction des repas consommes
        for (Maladies maladie : maladies) {
            List<String> symptomes = maladie.getSymptoms();
            List<String> repasCorrespondants = new ArrayList<>();
            for (Repas repas : repasconsommes) {
                if (symptomes.contains(repas.getConstituant())) {
                    repasCorrespondants.add(repas.getConstituant());
                }
            }
            if (repasCorrespondants.size() == symptomes.size()) {
                return maladie.getNom();
            }
        }
        return "Aucune maladie trouve!";
    }
    
    public List<Maladies> loadMaladiesFromCSV(String filePath) {
        List<Maladies> maladies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(new ClassPathResource(filePath).getFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String nom = values[0];
                String medicament = values[1];
                String[] symptomesArray = values[2].split(";");
                List<String> symptomes = new ArrayList<>();
                for (String symptome : symptomesArray) {
                    symptomes.add(symptome);
                }

                Maladies maladie = new Maladies(nom, medicament, symptomes);
                maladies.add(maladie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return maladies;
    }
}

<<<<<<< HEAD:src/main/java/com/studor/orientation_student/manager/controller/nutritionController/MaladiesController.java
package com.studor.orientation_student.manager.controller.nutritionController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studor.orientation_student.entities.nutritionEntities.DataNutrition;
import com.studor.orientation_student.manager.service.nouriture.DataNutritionGeneration;
import com.studor.orientation_student.manager.service.nouriture.MaladiesService;
import com.studor.orientation_student.manager.service.suggestionCour.GetAbsoluePath;

import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

@RestController
@RequestMapping("/maladies")
public class MaladiesController {
    
    
    @PostMapping("/prediction")
    public String effectuerClassification(@ModelAttribute DataNutrition dataModel) throws IOException {

        // generation du fichier pour la recherche de la class
        dataModel.setNom("?");
        dataModel.setNomrepas1(dataModel.getNomrepas1().replace(" ", "_"));
        dataModel.setNomrepas2(dataModel.getNomrepas2().replace(" ", "_"));
        dataModel.setNomrepas3(dataModel.getNomrepas3().replace(" ", "_"));
        dataModel.setSymptoms(dataModel.getSymptoms().replace(" ", "_"));
        List<DataNutrition> dataModels = new ArrayList<>();
        dataModels.add(dataModel);
        DataNutritionGeneration dataGeneration = new DataNutritionGeneration();
        dataGeneration.writeARFFFile(dataModels, 0);

        Classifier modele = MaladiesService.classifyData();
        String predictedClassName = " aucune maladie trouver";
        Instances testData;
        try {

            GetAbsoluePath getAbsoluePath = new GetAbsoluePath();
            String path = getAbsoluePath.getAbsolutePathOfFile();
            path = path + "/data/nutritionData/dataNutritionprediction.arff";

            // Charger les données de test à partir d'un fichier ARFF
            DataSource testSource = new DataSource(path);
            testData = testSource.getDataSet();

            // Définir l'attribut de classe pour les données de test
            testData.setClassIndex(testData.numAttributes() - 1);

            // Effectuer la classification sur les données de test
            for (int i = 0; i < testData.numInstances(); i++) {
                double predictedClass = modele.classifyInstance(testData.instance(i));
                predictedClassName = testData.classAttribute().value((int) predictedClass);
                System.out.println("Instance " + (i + 1) + ": Classe prédite = " + predictedClassName);
            }
            return "<h1> La maladie predite est > : "+ predictedClassName +" </h1>";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erreur lors de la classification.\n" + e.getMessage() + " \n";
        }
    }
}
=======
>>>>>>> 5c5518d1aae51446ecea22dd789d7ddde17fea9e:src/main/java/com/studor/orientation_student/manager/controller/nutritionController/maladiesController.java

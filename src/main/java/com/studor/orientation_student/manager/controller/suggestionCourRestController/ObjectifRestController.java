package com.studor.orientation_student.manager.controller.suggestionCourRestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studor.orientation_student.entities.suggestionCourEntities.DataModel;
import com.studor.orientation_student.manager.service.suggestionCour.ClassificationData;
import com.studor.orientation_student.manager.service.suggestionCour.DataGeneration;
import com.studor.orientation_student.manager.service.suggestionCour.GetAbsoluePath;

import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

@RestController
public class ObjectifRestController {

    // @Autowired
    // private ClassificationData classificationData;

    // @Autowired
    // private Classifier modele; // Votre modèle préalablement entraîné

    @PostMapping("/classification")
    public String effectuerClassification(@ModelAttribute DataModel dataModel) throws IOException {

        // generation du fichier pour la recherche de la class
        dataModel.setNomEmpoitemps("?");
        dataModel.setMoyenneScolaire(dataModel.getMoyenneScolaire().replace(" ", "_"));
        dataModel.setStatutProfessionnel(dataModel.getStatutProfessionnel().replace(" ", "_"));
        List<DataModel> dataModels = new ArrayList<>();
        dataModels.add(dataModel);
        DataGeneration dataGeneration = new DataGeneration();
        dataGeneration.writeARFFFile(dataModels, 1);

        Classifier modele = ClassificationData.classifyData();
        String predictedClassName = " aucune class trouver";
        Instances testData;
        try {

            GetAbsoluePath getAbsoluePath = new GetAbsoluePath();
            String path = getAbsoluePath.getAbsolutePathOfFile();
            path = path + "/data/fichier_test.arff";

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
            return "<h1> L'emploi de temps predit est > : " + predictedClassName +" </h1>";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erreur lors de la classification.\n" + e.getMessage() + " \n";
        }
    }

}

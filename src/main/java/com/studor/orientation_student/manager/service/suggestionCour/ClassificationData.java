package com.studor.orientation_student.manager.service.suggestionCour;


import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import java.util.ArrayList;
import java.util.List;

import com.studor.orientation_student.entities.suggestionCourEntities.ModelSuggestionCour;
import com.studor.orientation_student.manager.controller.suggestionCourRestController.ObjectifRestController.TestExample;
import com.studor.orientation_student.manager.controller.suggestionCourRestController.ObjectifRestController.TrainingExample;

public class ClassificationData {
  

 
    
    private Instances trainingData;
    private Instances testData;

    public ClassificationData(List<TrainingExample> trainingExamples, List<TestExample> testExamples) {
        // Création de l'attribut de classe
        ArrayList<String> classValues = new ArrayList<>();
        classValues.add("class1");
        classValues.add("class2");
        Attribute classAttribute = new Attribute("class", classValues);

        // Création de l'attribut(s) prédictif(s)
        Attribute attribute1 = new Attribute("attribute1");
        Attribute attribute2 = new Attribute("attribute2");

        // Création de la liste des attributs
        ArrayList<Attribute> attributeList = new ArrayList<>();
        attributeList.add(attribute1);
        attributeList.add(attribute2);
        attributeList.add(classAttribute);

        // Création de l'ensemble de données d'entraînement
        trainingData = new Instances("TrainingData", attributeList, trainingExamples.size());
        trainingData.setClassIndex(trainingData.numAttributes() - 1); // Définir l'attribut de classe

        for (TrainingExample example : trainingExamples) {
            Instance instance = new DenseInstance(3); // 3 est le nombre d'attributs
            instance.setValue(attribute1, example.getPoids());
            instance.setValue(attribute2, example.getTaille());
            instance.setValue(classAttribute, example.getTeint());
            trainingData.add(instance);
        }

        // Création de l'ensemble de données de test
        testData = new Instances("TestData", attributeList, testExamples.size());
        testData.setClassIndex(testData.numAttributes() - 1); // Définir l'attribut de classe

        for (TestExample example : testExamples) {
            Instance instance = new DenseInstance(3); // 3 est le nombre d'attributs
            instance.setValue(attribute1, example.getPoids());
            instance.setValue(attribute2, example.getTaille());
            instance.setDataset(testData);
            testData.add(instance);
        }
    }

    public Instances getTrainingData() {
        return trainingData;
    }

    // public static void main(String[] args) {
    //     // Création des exemples d'entraînement et de test
    //     List<ModelSuggestionCour> trainingExamples = new ArrayList<>();
    //     trainingExamples.add(new ModelSuggestionCour("cenior"));
    //     trainingExamples.add(new ModelSuggestionCour("minime"));

    //     List<ModelSuggestionCour> testExamples = new ArrayList<>();
    //     testExamples.add(new ModelSuggestionCour("cadet"));
    //     testExamples.add(new ModelSuggestionCour("amateur"));

    //     // Création de l'objet ClassificationData
    //     ClassificationData data = new ClassificationData(trainingExamples, testExamples);

    //     // Utilisation des données d'entraînement
    //     Instances trainingData = data.getTrainingData();
    //     System.out.println("Nombre d'instances dans les données d'entraînement : " + trainingData.numInstances());

    //     // Utilisation des données de test
    //     Instances testData = data.getTestData();
    //     System.out.println("Nombre d'instances dans les données de test : " + testData.numInstances());
    // }
}

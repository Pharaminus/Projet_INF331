package com.studor.orientation_student.manager.service.suggestionCour;

import weka.classifiers.Classifier;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;

public class DataProcessor {
        public void performTraining(Instances trainingData) throws Exception {
        // Créer une instance du classifieur (par exemple, J48)
        Classifier classifier = new J48();
            
        // Entraîner le modèle sur les données d'entraînement
        classifier.buildClassifier(trainingData);

        // Évaluer le modèle en utilisant la validation croisée (par exemple, 10-fold cross-validation)
        Evaluation evaluation = new Evaluation(trainingData);
        evaluation.crossValidateModel(classifier, trainingData, 10, new java.util.Random(1));

        // Afficher les résultats de l'évaluation
        System.out.println(evaluation.toSummaryString());

        // Utiliser le modèle entraîné pour la prédiction ou l'évaluation ultérieure
        // ...
    }
}

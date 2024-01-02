package com.studor.orientation_student.manager.service.suggestionCour;

import org.springframework.stereotype.Service;

import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;


@Service
public class SuggestionCourClassificationService {
    
    public void classificationParArbreDecisionel(Instances donneApprentissage, Instances donneTest){
        try {
            
            if(donneApprentissage.classIndex() == -1){
                donneApprentissage.indexOf(donneApprentissage.numAttributes() - 1);
            }

            if(donneTest.classIndex() == -1){
                donneTest.indexOf(donneTest.numAttributes() - 1);
            }

            // creation et entrainement de l'arbre
            J48 arbre = new J48();
            arbre.buildClassifier(donneApprentissage);
            
            // utilisation de l'arbre de decision pour la classification des nouvelles instances
            for(int i = 0; i < donneTest.numInstances(); i++){
                double prediction = arbre.classifyInstance(donneTest.instance(i));
                System.out.println("Class predite: "+ donneTest.classAttribute().value( (int) prediction));
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

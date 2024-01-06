package com.studor.orientation_student.manager.service.nouriture;

import org.springframework.stereotype.Service;

import com.studor.orientation_student.entities.nutritionEntities.Maladies;
import com.studor.orientation_student.manager.service.suggestionCour.GetAbsoluePath;

import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

@Service
public class MaladiesService {

    // methode pour consulter un medicament d'urgence a une maladie
   public String getMedicamentUrgence(Maladies maladies)
   {
        return maladies.getMedicament();
   }
   // methode pour predire les maladies en fonctions des 5 dernier repas consommes
   public static Classifier classifyData() {
        try {
            // Charger les données à partir d'un fichier .arff
            GetAbsoluePath getAbsoluePath = new GetAbsoluePath();
            String path = getAbsoluePath.getAbsolutePathOfFile();
            path = path + "/data/nutritionData/dataNutritionForTrainning.arff";
            DataSource source = new DataSource(path);
            Instances data = source.getDataSet();
            
            // System.out.println(">>>>>>>>>>( "+path);

            System.out.println();
            if (data.classIndex() == -1) {
                data.setClassIndex(data.numAttributes() - 1);
            }

            // Entraîner un modèle J48 (arbre de décision)
            Classifier tree = new J48();
            tree.buildClassifier(data);

           
            return tree;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

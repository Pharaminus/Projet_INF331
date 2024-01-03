package com.studor.orientation_student.manager.service.suggestionCour;


import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.classifiers.Classifier;
import weka.core.converters.ConverterUtils.DataSource;

public class ClassificationData{
    public static Classifier classifyData() {
        try {
            // Charger les données à partir d'un fichier .arff
            GetAbsoluePath getAbsoluePath = new GetAbsoluePath();
            String path = getAbsoluePath.getAbsolutePathOfFile();
            path = path + "/data/suggestionCourData/dataForTrainning.arff";
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
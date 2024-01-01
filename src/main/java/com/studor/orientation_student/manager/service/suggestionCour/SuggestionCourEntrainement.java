package com.studor.orientation_student.manager.service.suggestionCour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import weka.classifiers.Classifier;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

public class SuggestionCourEntrainement {
    @Autowired
    private DataProcessor dataProcessor;

     @Component
    public class DataProcessor implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            // Charger les données
            Instances data = loadData();

            // Diviser les données en ensembles d'entraînement et de test
            double trainRatio = 0.8; // Ratio d'entraînement (80%)
            int trainSize = (int) (data.numInstances() * trainRatio);

            Instances trainData = new Instances(data, 0, trainSize);
            Instances testData = new Instances(data, trainSize, data.numInstances() - trainSize);

            // Effectuer l'entraînement et le test avec les données
            performTraining(trainData);
            performTesting(testData);
        }

        private Instances loadData() throws Exception {
            // Créer la structure de l'ensemble de données
            List<Attribute> attributes = createAttributes(); // Méthode à implémenter

            // Créer un nouvel ensemble de données vide
            Instances data = new Instances("data", (ArrayList<Attribute>) attributes, 0);

            // Charger les données à partir de l'objet Java
            List<MyData> javaData = getJavaData(); // Méthode à implémenter

            // Ajouter les instances au jeu de données
            for (MyData dataItem : javaData) {
                Instance instance = convertToInstance(dataItem, data);
                data.add(instance);
            }

            // Définir l'attribut de classe
            data.setClassIndex(data.numAttributes() - 1);

            return data;
        }

        private List<Attribute> createAttributes() {
            // Créez et retournez la liste des attributs pour votre jeu de données
            // Définissez les attributs appropriés en fonction de votre modèle de données
            // Par exemple :
            List<Attribute> attributes = new ArrayList<>();
            attributes.add(new Attribute("attribute1"));
            attributes.add(new Attribute("attribute2"));
            // ...
            attributes.add(new Attribute("class", Arrays.asList("class1", "class2")));
            return attributes;
        }

        private Instance convertToInstance(MyData dataItem, Instances data) {
            // Créez une instance Weka à partir de l'objet de données Java
            Instance instance = new DenseInstance(data.numAttributes());

            // Définir les valeurs des attributs de l'instance
            instance.setValue(0, dataItem.getDifficulte());
            instance.setValue(1, dataItem.getMoyenne());
            // ...

            // Définir la valeur de l'attribut de classe de l'instance
            instance.setValue(data.numAttributes() - 1, dataItem.getNiveau());

            // Définir le jeu de données de l'instance
            instance.setDataset(data);

            return instance;
        }

        private void performTraining(Instances trainData) throws Exception {
            // Code pour effectuer l'entraînement sur les données
            // Remplacez ce code par votre propre logique d'entraînement
            Classifier classifier = new J48();
            classifier.buildClassifier(trainData);
        }

        private void performTesting(Instances testData) throws Exception {
            // Code pour effectuer le test sur les données
            // Remplacez ce code par votre propre logique de test
            Classifier classifier = new J48();
            Evaluation evaluation = new Evaluation(testData);
            evaluation.evaluateModel(classifier, testData);
            System.out.println(evaluation.toSummaryString());
        }

     



    }

    private List<Attribute> createAttributes() {
        List<Attribute> attributes = new ArrayList<>();
    
        // Attribut 1 : Nom (String)
        Attribute nameAttribute = new Attribute("name");
        attributes.add(nameAttribute);
    
        // Attribut 2 : Âge (numeric)
        Attribute ageAttribute = new Attribute("age");
        attributes.add(ageAttribute);
    
        // Attribut 3 : Profession (nominal)
        List<String> professionValues = Arrays.asList("Engineer", "Doctor", "Teacher", "Artist");
        Attribute professionAttribute = new Attribute("profession", professionValues);
        attributes.add(professionAttribute);
    
        // Attribut de classe : Catégorie (nominal)
        List<String> classValues = Arrays.asList("A", "B", "C");
        Attribute classAttribute = new Attribute("class", classValues);
        attributes.add(classAttribute);
    
        return attributes;
    }
    
    private List<MyData> getJavaData() {
        List<MyData> javaData = new ArrayList<>();
    
        // Exemple de données
        MyData data1 = new MyData("John", "30", "Engineer", "A");
        MyData data2 = new MyData("Alice", "25", "Doctor", "B");
        MyData data3 = new MyData("Bob", "40", "Teacher", "C");
    
        javaData.add(data1);
        javaData.add(data2);
        javaData.add(data3);
    
        return javaData;
    }

    

}

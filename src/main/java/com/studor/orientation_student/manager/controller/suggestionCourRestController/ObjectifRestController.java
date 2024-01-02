package com.studor.orientation_student.manager.controller.suggestionCourRestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studor.orientation_student.entities.suggestionCourEntities.EmploiTemps;
import com.studor.orientation_student.entities.suggestionCourEntities.ModelSuggestionCour;
import com.studor.orientation_student.manager.service.suggestionCour.ClassificationData;
import com.studor.orientation_student.manager.service.suggestionCour.SuggestionCourClassificationService;

import weka.core.Instances;

@RestController
@RequestMapping("/objectifRest")
public class ObjectifRestController {
    private SuggestionCourClassificationService classificationService;

    public ObjectifRestController(SuggestionCourClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    // @PostMapping("/classer")
    @GetMapping("/classer")

    public String classerParAbreDecisionnel() {
        // public String classerParAbreDecisionnel(@RequestBody ModelSuggestionCour
        // model){
        // Création des exemples d'entraînement et de test
        // List<ModelSuggestionCour> trainingExamples = new ArrayList<>();
        // trainingExamples.add(new ModelSuggestionCour("cenior", "passable",new EmploiTemps((long) 12,"facile" , "defaut")));
        // trainingExamples.add(new ModelSuggestionCour("cadet", "bien",new EmploiTemps((long) 20,"difficile" , "defaut")));

        // List<ModelSuggestionCour> testExamples = new ArrayList<>();
        // testExamples.add(new ModelSuggestionCour("cenior", "tres bien",new EmploiTemps((long) 34,"facile" , "personalise")));
        // testExamples.add(new ModelSuggestionCour("professionnel", "passable",new EmploiTemps((long) 12,"facile" , "defaut")));

        // // Création de l'objet ClassificationData
        // ClassificationData data = new ClassificationData(trainingExamples, testExamples);

        // // Utilisation des données d'entraînement
        // Instances trainingData = data.getTrainingData();
        // System.out.println("Nombre d'instances dans les données d'entraînement : " + trainingData.numInstances());

        // // Utilisation des données de test
        // Instances testData = data.getTestData();
        // System.out.println("Nombre d'instances dans les données de test : " + testData.numInstances());


        // Création des exemples d'entraînement et de test
        // List<TrainingExample> trainingExamples = new ArrayList<>();
        // trainingExamples.add(new TrainingExample(1.0, 2.0, "class1"));
        // trainingExamples.add(new TrainingExample(3.0, 4.0, "class2"));

        // List<TestExample> testExamples = new ArrayList<>();
        // testExamples.add(new TestExample(2.0, 3.0));
        // testExamples.add(new TestExampel(4.0, 5.0));

        // // Création de l'objet ClassificationData
        // ClassificationData data = new ClassificationData(trainingExamples, testExamples);

        // // Utilisation des données d'entraînement
        // Instances trainingData = data.getTrainingData();
        // System.out.println("Nombre d'instances dans les données d'entraînement : " + trainingData.numInstances()+ " ");

        // Utilisation des données de test
        // Instances testData = data.getTrainingData()     ;
        
        
        
        return "ok";
    }

    public class TestExample{
        private Double taille;
        private Double poids;
        // private String teint;
        public TestExample() {
        }
        public TestExample(Double taille, Double poids) {
            this.taille = taille;
            this.poids = poids;
            // this.teint = teint;
        }
        public Double getTaille() {
            return taille;
        }
        public void setTaille(Double taille) {
            this.taille = taille;
        }
        public Double getPoids() {
            return poids;
        }
        public void setPoids(Double poids) {
            this.poids = poids;
        }
        

        
    }

    public class TrainingExample{
        private Double taille;
        private Double poids;
        private String teint;
        public TrainingExample() {
        }
        public TrainingExample(Double taille, Double poids, String teint) {
            this.taille = taille;
            this.poids = poids;
            this.teint = teint;
        }
        public Double getTaille() {
            return taille;
        }
        public void setTaille(Double taille) {
            this.taille = taille;
        }
        public Double getPoids() {
            return poids;
        }
        public void setPoids(Double poids) {
            this.poids = poids;
        }
            public String getTeint() {
                return teint;
        }
        public void setTeint(String teint) {
            this.teint = teint;
        }

        
    }
}

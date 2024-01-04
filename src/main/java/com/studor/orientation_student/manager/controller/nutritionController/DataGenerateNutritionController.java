package com.studor.orientation_student.manager.controller.nutritionController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studor.orientation_student.entities.nutritionEntities.DataNutrition;
import com.studor.orientation_student.manager.service.nouriture.DataNutritionGeneration;
import com.studor.orientation_student.manager.service.suggestionCour.MakeModelClassification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DataGenerateNutritionController {

    @GetMapping("/nutrition-generate-arff")
    public String generateARFF() throws IOException {
        DataNutritionGeneration dataNutritionGeneration = new DataNutritionGeneration();
        List<DataNutrition> dataModels = new ArrayList<>();

        dataModels = dataNutritionGeneration.generateRandomData(200);
        dataNutritionGeneration.writeARFFFile(dataModels, 1);
        MakeModelClassification makeModelClassification = new MakeModelClassification();
        // ModelSuggestionCour modelSuggestionCour = makeModelClassification.buildAndSaveModel();
        return "donne generer avec succes !!!";
    }
}

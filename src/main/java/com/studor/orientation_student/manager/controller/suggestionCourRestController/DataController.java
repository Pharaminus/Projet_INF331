package com.studor.orientation_student.manager.controller.suggestionCourRestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.studor.orientation_student.entities.suggestionCourEntities.DataModel;
import com.studor.orientation_student.manager.service.suggestionCour.DataGeneration;
import com.studor.orientation_student.manager.service.suggestionCour.GetAbsoluePath;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class DataController {
    

    @GetMapping("/generate-arff")
    public String generateARFF() throws IOException {
        DataGeneration dataGeneration = new DataGeneration();
        List<DataModel> dataModels = new ArrayList<>();

        dataModels = dataGeneration.generateRandomData(100);
        dataGeneration.writeARFFFile(dataModels, 0);
        return "donne generer avec succes !!!";
    }

    
}
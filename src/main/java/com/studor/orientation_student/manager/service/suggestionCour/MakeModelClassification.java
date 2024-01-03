package com.studor.orientation_student.manager.service.suggestionCour;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.studor.orientation_student.entities.suggestionCourEntities.ModelSuggestionCour;
import com.studor.orientation_student.manager.repository.suggestionCourRepository.ModelSuggestionCourRepository;

import weka.classifiers.Classifier;
import weka.core.SerializationHelper;

public class MakeModelClassification {

    @Autowired
    private ModelSuggestionCourRepository modelSuggestionCourRepository;

    public ModelSuggestionCour buildAndSaveModel() {
        // System.out.println("+++++======> ok test !");

        Classifier tree = ClassificationData.classifyData();
        

        ModelSuggestionCour modelSuggestionCour = new ModelSuggestionCour();
        modelSuggestionCour.setClassifier(tree);
        modelSuggestionCour.setVersion("version 1.1.0");
        // byte[] serialisezeModel = SerializationHelper.((Serializable) tree);
        modelSuggestionCour.setSerialisezeModel(modelSuggestionCour.getSerialisezeModel());

        modelSuggestionCour = modelSuggestionCourRepository.save(modelSuggestionCour);
        if (modelSuggestionCour != null)
            System.out.println("+++++======> ok test !");
        return modelSuggestionCour;
    }
}
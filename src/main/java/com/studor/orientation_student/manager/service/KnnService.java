package com.studor.orientation_student.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studor.orientation_student.manager.repository.ProfilRepository;
import weka.classifiers.lazy.IBk;
import weka.core.Instances;

@Service
public class KnnService {

    @Autowired
    private ProfilRepository profilRepo;

    public IBk trainModel() throws Exception {
        Instances instances = profilRepo.getInstancesFromDatabase(); // Fetch instances from database
        instances.setClassIndex(instances.numAttributes() - 1); // Set the class attribute

        IBk knn = new IBk();
        knn.buildClassifier(instances); // Train the model

        return knn;
    }
}

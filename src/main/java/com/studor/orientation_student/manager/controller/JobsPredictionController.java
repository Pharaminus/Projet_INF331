package com.studor.orientation_student.manager.controller;

import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studor.orientation_student.entities.suggestionCourEntities.profilejobprediction.Jobs;
import com.studor.orientation_student.manager.repository.JobsRepository;
import com.studor.orientation_student.manager.service.WekaClassify;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/profile-job")
public class JobsPredictionController {

    @Autowired
    private JobsRepository jobsRepository;

    @GetMapping("/test")
    public String testGet() throws Exception {

        String projectPath = Paths.get("").toAbsolutePath().toString();
        String trainingDataFile = projectPath + "/data/dataSource.arff";
        String predictedClassValue = WekaClassify.trainModel(trainingDataFile, 15.24, 16.58, 13.49, 14.76);
        Jobs job = jobsRepository.findByNom(predictedClassValue);
        System.out.println("==============>>>>>>>>>>>>>>Job("+"Name: "+job.getNom()+" Description: "+job.getDescription()+" Time: "+job.getDureeFormation()+" Salaire: "+job.getSalaire()+" Category: "+job.getCategory().getNom()+")");
        return jobPredicted();
    }

    @PostMapping("/send-notes")
    public String postMethodName(@RequestParam("matNotes") double mathNotes, @RequestParam("phyNotes") double phyNotes, 
    @RequestParam("infoNotes") double infoNotes, @RequestParam("mean") double mean) throws Exception {

        String projectPath = Paths.get("").toAbsolutePath().toString();
        String trainingDataFile = projectPath + "/data/dataSource.arff";
        String predictedClassValue = WekaClassify.trainModel(trainingDataFile, mathNotes, phyNotes, infoNotes, mean);
        Jobs jobs = jobsRepository.findByNom(predictedClassValue);
        System.out.println("================>>>>>>>>>>>"+jobs.getNom());

        return jobPredicted();
    }

    @GetMapping("/predicted")
    public String jobPredicted() {
        return "profile-job-predicted";
    }
}

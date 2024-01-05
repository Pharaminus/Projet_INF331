package com.studor.orientation_student.manager.controllers.profilejobpredictcontroller;

import java.nio.file.Paths;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studor.orientation_student.manager.services.profilepredictionservices.JobPredictService;
import com.studor.orientation_student.manager.services.profilepredictionservices.NotesReportSaverService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/profile-job")
public class JobsPredictionRestController {

    @Autowired
    private JobPredictService jobPredictService;

    @Autowired
    private NotesReportSaverService notesReportSaverService;

    @GetMapping("/check-test")
    public String existNotesCheck(HttpSession session) throws Exception {
        return notesReportSaverService.checkIfNotesReportExists(session);
    }

    @GetMapping("/predicted")
    public Map<String, Object> jobPredictByDataFromTheForm(HttpSession session) throws Exception {

        String projectPath = Paths.get("").toAbsolutePath().toString();
        String trainingDataFile = projectPath + "/data/dataSource.arff";

        return jobPredictService.predictJobUsingDataInDatabase(session, trainingDataFile);
    }
}

package com.studor.orientation_student.manager.controllers.restcontrollers;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.studor.orientation_student.manager.services.profilepredictionservices.JobPredictService;
import com.studor.orientation_student.manager.services.profilepredictionservices.NotesReportSaverService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/job-api")
public class JobPredictionRestController {

    @Autowired
    private JobPredictService jobPredictService;

    @Autowired
    private NotesReportSaverService notesReportSaverService;

    @GetMapping("/check-test")
    public String checkNotesReport(HttpSession session) throws Exception {
        return notesReportSaverService.checkIfNotesReportExists(session);
    }

    @GetMapping("/predicted")
    public Map<String, Object> jobPredictByDataFromTheForm(HttpSession session) throws Exception {

        String projectPath = Paths.get("").toAbsolutePath().toString();
        String trainingDataFile = projectPath + "/data/dataSource.arff";

        return jobPredictService.predictJobUsingDataInDatabase(session, trainingDataFile);
    }

    @GetMapping("/all-level")
    public List<String> getAllLevelFromDatabase() {
        return notesReportSaverService.getAllLevel();
    }

    @GetMapping("/all-option")
    public List<String> getAllOptionFromDatabase() {
        return notesReportSaverService.getAllOption();
    }

    @PostMapping("/send-notes")
    public Map<String, Object>  sendNotesForJobPrediction(HttpSession session, @RequestParam("type") String type,
            @RequestParam("niveau") String niveau,
            @RequestParam("mathNote") double mathNote,
            @RequestParam("phyNote") double phyNote, @RequestParam("infoNote") double infoNote,
            @RequestParam("chmNote") double chmNote, @RequestParam("engNote") double engNote,
            @RequestParam("fraNote") double fraNote) throws Exception {

        System.out.println("------------==========================" + type + "-------=========------------" + niveau
                + "-------====------" + phyNote);
        String result = notesReportSaverService.saveNotesReport(session, mathNote, phyNote, infoNote, chmNote, engNote,
                fraNote, type, niveau);
        if (result == "OK") {
            String projectPath = Paths.get("").toAbsolutePath().toString();
            String trainingDataFile = projectPath + "/data/dataSource.arff";
            return jobPredictService.predictJobUsingDataInDatabase(session, trainingDataFile);
        }
        else{
            return null;
        }
    }

    // @GetMapping("/predict")
    // public ModelAndView getJobInfo(HttpSession session) throws Exception {
    //     ModelAndView model = new ModelAndView("job-prediction");

    //     String projectPath = Paths.get("").toAbsolutePath().toString();
    //     String trainingDataPath = projectPath+"/data/dataSource.arff";

    //     Map<String, Object> jobpredicted = jobPredictService.predictJobUsingDataInDatabase(session, trainingDataPath);
    //     model.addObject("jobMap", jobpredicted);
    //     return model;
    // }
    
}

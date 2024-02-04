package com.studor.orientation_student.manager.controllers.jobpredictcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.studor.orientation_student.manager.services.profilepredictionservices.NotesReportSaverService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/job")
public class JobPredictionController {

    // @Autowired
    // private JobPredictService jobPredictService;

    @Autowired
    private NotesReportSaverService notesReportSaverService;

    @PostMapping("/send-notes")
    public RedirectView sendNotesForJobPrediction(Model model, HttpSession session, @RequestParam("type") String type,
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
            return new RedirectView("/job/home-predict");
        } else {
            return new RedirectView("/login/form");
        }
    }

    @GetMapping("/predicted")
    public String jobPredicted(HttpSession session, Model model) throws Exception {

        // String projectPath = Paths.get("").toAbsolutePath().toString();
        // String trainingDataFile = projectPath+"/data/dataSource.arff";

        // Map<String, Object> jobMap = new HashMap<>();
        // jobMap = jobPredictService.predictJobUsingDataInDatabase(session, trainingDataFile);

        // model.addAttribute("job-predicted-info", jobMap);
        return "establishment-job-templates/job-prediction";
    }

    @GetMapping("/home-predict")
    public String showEstablishmentPage(HttpSession session) {
        return "establishment-job-templates/job-prediction";
    }
}

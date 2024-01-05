package com.studor.orientation_student.manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studor.orientation_student.manager.services.profilepredictionservices.NotesReportSaverService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class MainController {

    @Autowired
    private NotesReportSaverService notesReportSaverService;

    @GetMapping("")
    public String home(HttpSession session) {
        if (session != null) {
            String email = (String) session.getAttribute("email");
            System.out.println("=======================>>>>>>>>>>>>>" + email);
            return "establishment-job-templates/profile-job-predicted";
        } else {
            return "test-form";
        }
    }

    @PostMapping("/send-notes")
    public String jobPredicted(HttpSession session, @RequestParam("type") String type,
            @RequestParam("niveau") String niveau,
            @RequestParam("mention") String mention,
            @RequestParam("mathNote") double mathNote,
            @RequestParam("phyNote") double phyNote, @RequestParam("infoNote") double infoNote,
            @RequestParam("chmNote") double chmNote, @RequestParam("engNote") double engNote,
            @RequestParam("fraNote") double fraNote) {

        System.out.println("------------==========================" + type + "-------=========------------" + niveau
                + "-------====------" + mention + "-----=====-------" + phyNote);
        String result = notesReportSaverService.saveNotesReport(session, mathNote, phyNote, infoNote, chmNote, engNote,
                fraNote, mention, type, niveau);
        if (result == "OK") {
            return "establishment-job-templates/profile-job-predicted";
        } else {
            return "test-form";
        }
    }
}

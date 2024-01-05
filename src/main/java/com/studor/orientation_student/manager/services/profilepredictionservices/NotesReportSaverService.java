package com.studor.orientation_student.manager.services.profilepredictionservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.studor.orientation_student.entities.profilejobprediction.Matter;
import com.studor.orientation_student.entities.profilejobprediction.Notes;
import com.studor.orientation_student.entities.profilejobprediction.NotesReport;
import com.studor.orientation_student.entities.profilejobprediction.User;
import com.studor.orientation_student.manager.repositories.profilejobpredictrepository.MatterRepository;
import com.studor.orientation_student.manager.repositories.profilejobpredictrepository.NotesReportRepository;
import com.studor.orientation_student.manager.repositories.profilejobpredictrepository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
@SessionScope
public class NotesReportSaverService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MatterRepository matterRepository;

    @Autowired
    private NotesReportRepository notesReportRepository;

    public String checkIfNotesReportExists(HttpSession session){

        String userEmail = (String)session.getAttribute("email");
        if (session.getAttribute("email") != null) {
            User user = userRepository.findByEmail(userEmail);
            NotesReport notesReport = user.getProfil().getNotesReport();
            if(notesReport == null){
                System.out.println("hello");
                return "false";
            }
            else{
                System.out.println("bye");
                return "true";
            }
        }
        return null;
    }

    public String saveNotesReport(HttpSession session, double mathNote, double phyNote,double infoNote,
        double chmNote, double engNote, double fraNote, String mention, String type, String niveau){

            if(session.getAttribute("email") != null){
                String userEmail = (String)session.getAttribute("email");
                User user = userRepository.findByEmail(userEmail);
                NotesReport notesReport = new NotesReport();
                notesReport.setMention(mention);
                List<Matter> matters = matterRepository.findByTypeAndNiveau(type, niveau);
                System.out.println("----------========="+type+"===============-----------------=============="+niveau);
                System.out.println(matters.get(0).getNiveau());
                int mathCoef = matters.get(0).getCoef();
                int phyCoef = matters.get(1).getCoef();
                int infoCoef = matters.get(2).getCoef();
                int chmCoef = matters.get(3).getCoef();
                int engCoef = matters.get(4).getCoef();
                int fraCoef = matters.get(5).getCoef();
                int total = mathCoef + phyCoef + infoCoef + chmCoef + engCoef + fraCoef;
                double mean = (mathNote*mathCoef + phyNote*phyCoef + infoNote*infoCoef + chmNote*chmCoef + engNote*engCoef + fraNote*fraCoef)/total;
                notesReport.setMoyenne(mean);
                List<Notes> notes = new ArrayList<>();
                notes.add(new Notes(mathNote, notesReport, matters.get(0)));
                notes.add(new Notes(phyNote, notesReport, matters.get(1)));
                notes.add(new Notes(infoNote, notesReport, matters.get(2)));
                notes.add(new Notes(chmNote, notesReport, matters.get(3)));
                notes.add(new Notes(engNote, notesReport, matters.get(4)));
                notes.add(new Notes(fraNote, notesReport, matters.get(5)));
                notesReport.setNotes(notes);
                // notesReportRepository.findByP
                notesReport.setProfil(user.getProfil());
                notesReportRepository.save(notesReport);
                // System.out.println("-----------+==========================="+user.getProfil().getNotesReport().getId());
                // userRepository.save(user);
                return "OK";
            }
            else{
                return "Login please";
            }
    }
}

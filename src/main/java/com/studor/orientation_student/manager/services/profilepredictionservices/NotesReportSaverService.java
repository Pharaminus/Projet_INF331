package com.studor.orientation_student.manager.services.profilepredictionservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.studor.orientation_student.entities.profilejobprediction.Level;
import com.studor.orientation_student.entities.profilejobprediction.Matter;
import com.studor.orientation_student.entities.profilejobprediction.Notes;
import com.studor.orientation_student.entities.profilejobprediction.NotesReport;
import com.studor.orientation_student.entities.profilejobprediction.User;
import com.studor.orientation_student.manager.repositories.profilejobpredictrepository.LevelRepository;
import com.studor.orientation_student.manager.repositories.profilejobpredictrepository.MatterRepository;
import com.studor.orientation_student.manager.repositories.profilejobpredictrepository.NotesReportRepository;
import com.studor.orientation_student.manager.repositories.profilejobpredictrepository.OptionRepository;
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

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private OptionRepository optionRepository;

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

    public List<String> getAllLevel(){
        List<String> allCodeLevel = new ArrayList<>();
        levelRepository.findAll().forEach(level -> allCodeLevel.add(level.getCode()));
        return allCodeLevel;
    }

    public List<String> getAllOption(){
        List<String> allNameOption = new ArrayList<>();
        optionRepository.findAll().forEach(option -> allNameOption.add(option.getNom()));
        return allNameOption;
    }

    public String saveNotesReport(HttpSession session, double mathNote, double phyNote,double infoNote,
        double chmNote, double engNote, double fraNote, String type, String niveau){

            if(session.getAttribute("email") != null){
                String userEmail = (String)session.getAttribute("email");
                User user = userRepository.findByEmail(userEmail);
                NotesReport notesReport = new NotesReport();
                Level level = levelRepository.findByCode(niveau);
                List<Matter> matters = matterRepository.findByLevel(level);
                System.out.println("----------========="+type+"===============-----------------=============="+niveau);
                int mathCoef = matters.get(0).getCoef();
                int phyCoef = matters.get(1).getCoef();
                int infoCoef = matters.get(2).getCoef();
                int chmCoef = matters.get(3).getCoef();
                int engCoef = matters.get(4).getCoef();
                int fraCoef = matters.get(5).getCoef();
                int total = mathCoef + phyCoef + infoCoef + chmCoef + engCoef + fraCoef;
                double mean = (mathNote*mathCoef + phyNote*phyCoef + infoNote*infoCoef + chmNote*chmCoef + engNote*engCoef + fraNote*fraCoef)/total;
                notesReport.setMoyenne(mean);
                if(mean < 12.00 && mean >= 10.00){
                    notesReport.setMention("Passable");
                }
                else if(mean < 14.00 && mean >= 12.00){
                    notesReport.setMention("Assez Bien");
                }
                else if(mean < 16.00 && mean >= 14.00){
                    notesReport.setMention("Bien");
                }
                else if(mean < 18.00 && mean >= 16.00){
                    notesReport.setMention("Tres Bien");
                }
                else if(mean >= 18.00){
                    notesReport.setMention("Excellent");
                }
                List<Notes> notes = new ArrayList<>();
                notes.add(new Notes(mathNote, notesReport, matters.get(0)));
                notes.add(new Notes(phyNote, notesReport, matters.get(1)));
                notes.add(new Notes(infoNote, notesReport, matters.get(2)));
                notes.add(new Notes(chmNote, notesReport, matters.get(3)));
                notes.add(new Notes(engNote, notesReport, matters.get(4)));
                notes.add(new Notes(fraNote, notesReport, matters.get(5)));
                notesReport.setNotes(notes);
                notesReport.setProfil(user.getProfil());
                notesReportRepository.save(notesReport);
                return "OK";
            }
            else{
                return "Login please";
            }
    }
}

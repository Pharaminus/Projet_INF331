package com.studor.orientation_student.manager.services.profilepredictionservices;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.studor.orientation_student.entities.profilejobprediction.Job;
import com.studor.orientation_student.entities.profilejobprediction.Notes;
import com.studor.orientation_student.entities.profilejobprediction.NotesReport;
import com.studor.orientation_student.entities.profilejobprediction.User;
import com.studor.orientation_student.manager.repositories.profilejobpredictrepository.JobRepository;
import com.studor.orientation_student.manager.repositories.profilejobpredictrepository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
@SessionScope
public class JobPredictService {

    @Autowired
    private JobRepository jobsRepository;

    @Autowired
    private UserRepository userRepository;

    public Map<String, Object> predictJobUsingDataInDatabase(HttpSession session, String trainingDataFile)
            throws Exception {

        if (session.getAttribute("email") != null) {
            String emailSession = (String) session.getAttribute("email");
            User user = userRepository.findByEmail(emailSession);
            List<NotesReport> notesReports = user.getProfil().getNotesReports();
            List<Notes> notes = notesReports.get(notesReports.size() - 1).getNotes();
            System.out.println("======---Notes---======>Math: " + notes.get(0).getNote() + "-=Phy: "
                    + notes.get(1).getNote() + "-=Info: " + notes.get(2).getNote());
            double mathNotes = notes.get(0).getNote();
            double phyNotes = notes.get(1).getNote();
            double infoNotes = notes.get(2).getNote();
            int mathCoef = notes.get(0).getMatter().getCoef();
            int phyCoef = notes.get(1).getMatter().getCoef();
            int infoCoef = notes.get(2).getMatter().getCoef();
            int totalCoef = mathCoef + phyCoef + infoCoef;
            double mean = (mathNotes * mathCoef
                    + phyNotes * phyCoef + infoNotes * infoCoef)
                    / totalCoef;
            String predictedClassValue = WekaClassify.trainModel(trainingDataFile, mathNotes, phyNotes, infoNotes,
                    Math.round(mean));
            Job job = jobsRepository.findByNomIgnoreCase(predictedClassValue);
            user.getProfil().setJob(job);
            userRepository.save(user);
            // System.out.println("==============>>>>>>>>>>>>>>Job(" + "Name: " +
            // job.getNom() + " Description: "
            // + job.getDescription() + " Time: " + job.getTraining().getDuree() + " Salaire: " +
            // job.getSalaire()
            // + " Category: " + job.getCategory().getNom() + ")");

            Map<String, Object> jobMap = new HashMap<>();
            jobMap.put("name", job.getNom());
            jobMap.put("description", job.getDescription());
            jobMap.put("dureeFormation", job.getTraining().getDuree());
            jobMap.put("coutFormation", job.getTraining().getCout());
            List<String> establishmentNameList = new ArrayList<>();
            job.getTraining().getEstablishments().forEach(establishment -> establishmentNameList.add(establishment.getNom()));
            jobMap.put("establishment", establishmentNameList);
            jobMap.put("salary", job.getSalaire());
            Blob jobImageBlob = job.getImage();
            byte[] jobImagebytes = null;
            try (InputStream inputStream = jobImageBlob.getBinaryStream()) {
                jobImagebytes = inputStream.readAllBytes();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
            String jobImage = Base64.getEncoder().encodeToString(jobImagebytes);
            jobMap.put("jobImage", jobImage);
            jobMap.put("option", job.getOption().getNom());

            return jobMap;
        } else {
            return null;
        }
    }
}
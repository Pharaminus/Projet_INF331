package com.studor.orientation_student.manager.services.establishmentsuggestionservices;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.studor.orientation_student.entities.establishmentsuggestion.Establishment;
import com.studor.orientation_student.entities.establishmentsuggestion.Training;
import com.studor.orientation_student.entities.profilejobprediction.Job;
import com.studor.orientation_student.entities.profilejobprediction.User;
import com.studor.orientation_student.manager.repositories.establishmentsuggestcontroller.TrainingRepository;
import com.studor.orientation_student.manager.repositories.profilejobpredictrepository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
@SessionScope
public class EstablishmentSuggestService {

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private UserRepository userRepository;

    public Map<String, Object> suggestEstablishmentOnName(HttpSession session) {
        System.out.println((String) session.getAttribute("email"));

        // Check if user has already a session
        if (session.getAttribute("email") != null) {
            String email = (String) session.getAttribute("email");

            User user = userRepository.findByEmail(email);
            List<Establishment> establishments = user.getProfil().getJob().getTraining().getEstablishments();

            if (user.getProfil().getEstablishments() == null) {
                user.getProfil().setEstablishments(establishments);
                userRepository.save(user);
            }

            // Hash which i send to JS using ajax
            Map<String, Object> establishmentMap = new HashMap<>();
            establishmentMap.put("name", establishments.get(0).getNom());
            establishmentMap.put("location", establishments.get(0).getLocalisation());
            establishmentMap.put("directorName", establishments.get(0).getNomDirecteur());

            Blob establishmentImageBlob = establishments.get(0).getImage();
            byte[] establishmentImage = null;
            try (InputStream inputStream = establishmentImageBlob.getBinaryStream()) {
                establishmentImage = inputStream.readAllBytes();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
            establishmentMap.put("image", establishmentImage);

            Job job = user.getProfil().getJob();
            Training training = trainingRepository.findByJob(job);

            establishmentMap.put("trainingName", training.getNom());
            establishmentMap.put("trainingCost", training.getCout());
            establishmentMap.put("option", training.getJob().getOption().getNom());
            establishmentMap.put("domain", training.getJob().getOption().getDomain().getNom());

            List<String> trainingMatterName = new ArrayList<>();
            training.getMatters().forEach(matter -> trainingMatterName.add(matter.getNom()));
            establishmentMap.put("trainingMatterName", trainingMatterName);

            String trainingMatterLevel = training.getMatters().get(0).getLevel().getCode();
            establishmentMap.put("trainingMatterLevel", trainingMatterLevel);

            List<Integer> trainingMatterCredit = new ArrayList<>();
            training.getMatters().forEach(matter -> trainingMatterCredit.add(matter.getCoef()));
            establishmentMap.put("trainingMatterCredit", trainingMatterCredit);

            System.out.println(establishmentMap);

            return establishmentMap;
        }
        return null;
    }

    public Map<String, Object> getEstablishmentOnJob(HttpSession session) {

        if (session.getAttribute("email") != null) {
            String email = (String) session.getAttribute("email");

            User user = userRepository.findByEmail(email);
            List<Establishment> establishments = user.getProfil().getJob().getTraining().getEstablishments();

            Map<String, Object> establishmentMap = new HashMap<>();
            List<String> establishmensNameList = new ArrayList<>();
            establishments.forEach(establishment -> establishmensNameList.add(establishment.getNom()));
            establishmentMap.put("establishmentName", establishmensNameList);

            List<byte[]> establishmentImageList = new ArrayList<>();
            establishments.forEach(establishment -> {
                Blob establishmentImageBlob = establishment.getImage();
                byte[] establishmentImage = null;

                try (InputStream inputStream = establishmentImageBlob.getBinaryStream()) {
                    establishmentImage = inputStream.readAllBytes();
                } catch (SQLException | IOException e) {
                    e.printStackTrace();
                }
                establishmentImageList.add(establishmentImage);
            });
            establishmentMap.put("imageList", establishmentImageList);

            List<String> establishmentLocation = new ArrayList<>();
            establishments.forEach(establishment -> establishmentLocation.add(establishment.getLocalisation()));
            establishmentMap.put("locationList", establishmentLocation);

            List<String> establishmentDirectorNameList = new ArrayList<>();
            establishments.forEach(establishment -> establishmentDirectorNameList.add(establishment.getNomDirecteur()));
            establishmentMap.put("directorNameList", establishmentDirectorNameList);

            List<String> establishmentDomainNameList = new ArrayList<>();
            establishments.forEach(establishment -> establishment.getDomains().forEach(domain -> {
                if (!establishmentDomainNameList.contains(domain.getNom())) {
                    establishmentDomainNameList.add(domain.getNom());
                }
            }));
            System.out.println(establishmensNameList);
            establishmentMap.put("estabishmentDomainNamelist", establishmentDomainNameList);

            return establishmentMap;
        }
        return null;
    }

    public Map<String, Object> getEstablishment(HttpSession session, String string){
        //TODO more here
        return null;
    }
}

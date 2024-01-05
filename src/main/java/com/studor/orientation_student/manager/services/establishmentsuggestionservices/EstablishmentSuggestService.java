package com.studor.orientation_student.manager.services.establishmentsuggestionservices;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

// import com.studor.orientation_student.entities.establishmentsuggestion.Domain;
import com.studor.orientation_student.entities.establishmentsuggestion.Establishment;
import com.studor.orientation_student.manager.repositories.establishmentsuggestcontroller.EstablishmentRepository;

import jakarta.servlet.http.HttpSession;

@Service
@SessionScope
public class EstablishmentSuggestService {

    @Autowired
    private EstablishmentRepository establishmentRepository;

    // @Autowired
    // private TrainingRepository trainingRepository;

    // @Autowired
    // private DomainRepository domainRepository;

    // @Autowired
    // private UserRepository userRepository;

    // @Autowired
    // private ProfilRepository profilRepository;

    public Map<String, Object> searchEstablishmentByName(HttpSession session, String search) {
        System.out.println((String) session.getAttribute("email"));

        if (session.getAttribute("email") != null) {
            Establishment establishment = establishmentRepository.findByNom(search);
            Map<String, Object> establishmentMap = new HashMap<>();
            establishmentMap.put("name", establishment.getNom());
            establishmentMap.put("location", establishment.getLocalisation());
            establishmentMap.put("directorName", establishment.getNomDirecteur());

            Blob establishmentImageBlob = establishment.getImage();
            byte[] establishmentImage = null;
            try (InputStream inputStream = establishmentImageBlob.getBinaryStream()){
                establishmentImage = inputStream.readAllBytes();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
            establishmentMap.put("image", establishmentImage);

            List<String> domainsName = new ArrayList<>();
            establishment.getDomains().forEach(domain -> domainsName.add(domain.getNom()));
            establishmentMap.put("domain", domainsName);

            List<String> trainingName = new ArrayList<>();
            establishment.getDomains()
                    .forEach(domain -> domain.getTraining().forEach(training -> trainingName.add(training.getNom())));
            establishmentMap.put("trainingName", trainingName);

            List<Double> trainingCost = new ArrayList<>();
            establishment.getDomains()
                    .forEach(domain -> domain.getTraining().forEach(training -> trainingCost.add(training.getCout())));
            establishmentMap.put("trainingCost", trainingCost);

            List<String> trainingMatterName = new ArrayList<>();
            establishment.getDomains().forEach(domain -> domain.getTraining().forEach(
                    training -> training.getMatters().forEach(matter -> trainingMatterName.add(matter.getNom()))));
            establishmentMap.put("trainingMatterName", trainingMatterName);

            List<String> trainingMatterLevel = new ArrayList<>();
            establishment.getDomains().forEach(domain -> domain.getTraining().forEach(
                    training -> training.getMatters().forEach(matter -> trainingMatterLevel.add(matter.getNiveau()))));
            establishmentMap.put("trainingMatterLevel", trainingMatterLevel);

            List<Integer> trainingMatterCredit = new ArrayList<>();
            establishment.getDomains().forEach(domain -> domain.getTraining().forEach(
                    training -> training.getMatters().forEach(matter -> trainingMatterCredit.add(matter.getCoef()))));
            establishmentMap.put("trainingMatterCredit", trainingMatterCredit);
            
            System.out.println(establishmentMap);

            return establishmentMap;
        }
        return null;
    }

    // public Map<String, Object> searchEstablishmentByDomain(HttpSession session, String search) {

    //     if (session.getAttribute("email") != null) {
    //         Domain domain = domainRepository.findByNom(search);
    //         Set<Establishment> establishment = domain.getEstablishment();
            
    //     }
    //     return null;
    // }

    // public Establishment searchEstablishmentByTraining(HttpSession session, String search) {

    //     if (session.getAttribute("email") != null) {
    //         Training training = trainingRepository.findByNom(search);
    //         Establishment establishment = training.getEstablishment();
    //         return establishment;
    //     }
    //     return null;
    // }

    // public String valideEstablishment(HttpSession session, Establishment establishment) {
    //     if ((session.getAttribute("email") != null)) {
    //         String profileUser = (String) session.getAttribute("email");
    //         List<Establishment> establishments = new ArrayList<>();
    //         establishments.add(establishment);
    //         Profil profil = userRepository.findByEmail(profileUser).getProfil();
    //         profil.setEstablishments(establishments);
    //         profilRepository.save(profil);
    //         return establishment.getNom();
    //     }
    //     return null;
    // }
}

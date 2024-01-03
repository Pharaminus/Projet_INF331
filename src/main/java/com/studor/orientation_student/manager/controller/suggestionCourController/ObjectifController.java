package com.studor.orientation_student.manager.controller.suggestionCourController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studor.orientation_student.entities.suggestionCourEntities.ObjectifUtilisateur;
import com.studor.orientation_student.entities.suggestionCourEntities.Programme;
import com.studor.orientation_student.entity.profilejobprediction.User;
import com.studor.orientation_student.manager.repository.UserRepository;
import com.studor.orientation_student.manager.repository.suggestionCourRepository.ObjectifUtilisateurRepository;
import com.studor.orientation_student.manager.repository.suggestionCourRepository.ProgrammeRepository;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/objectif")
public class ObjectifController {

    @Autowired
    private HttpServletRequest request;

    @Autowired 
    private ProgrammeRepository programmeRepository;

    @Autowired
    private ObjectifUtilisateurRepository objectifUtilisateurRepository;

    @Autowired
    private UserRepository userRepository;

     @GetMapping("/infoObjectif")
    public String infoObjectif(HttpSession session, Model model){
        model.addAttribute("objectif", new ObjectifUtilisateur());

        return "suggestionCour/formObjectifUtilisateur";
    }

    @PostMapping("/saveObjectif")
    public String saveObjectif(HttpSession session, @ModelAttribute("objectif") ObjectifUtilisateur objectifUtilisateur){
        User user = (User) session.getAttribute("user"); // on recupere les identifiants de l'utilisateur
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                // User user2 =  (User) cookie.getValue();
            }
        }
        if(user == null ){
            System.out.println(">>>>> la session a ete suprimer");
            // return "suggestionCour/formErrorSession";
            return "loginForm";
        }
        else{
            User user1 = userRepository.findByEmail(user.getEmail()); // on recupere en base de donnee

            ObjectifUtilisateur objectifUtilisateur1 = objectifUtilisateurRepository.findByDescriptionAndMoyenneAndStatuVise(objectifUtilisateur.getDescription(), objectifUtilisateur.getMoyenne(), objectifUtilisateur.getStatuVise());
            
            if(objectifUtilisateur1 != null ){
                System.out.println(">>>>>> cet objectif a deja ete defini !");
            }
            else{
                objectifUtilisateur.setUser(user1);
                objectifUtilisateurRepository.save(objectifUtilisateur); // on sauvegarde l'objectif defini par l'utilisateur
                objectifUtilisateur = objectifUtilisateurRepository.findByDescriptionAndMoyenneAndStatuVise(objectifUtilisateur.getDescription(), objectifUtilisateur.getMoyenne(), objectifUtilisateur.getStatuVise());
                user1.setObjectifUtilisateur(objectifUtilisateur); // on met a jour les informations de la table utilisateur

            }

            
            Programme programme = new Programme(null, objectifUtilisateur.getDifficulte(), objectifUtilisateur.getDescription());
            
            Programme programme1 = programmeRepository.findByDescriptionAndDifficulte(programme.getDescription(), programme.getDifficulte());
            if(programme1 != null){
                System.out.println(">>>>>> ce programme a deja ete defini !");

            }
            else{
                programme.setUser(user1);
                programmeRepository.save(programme);
                programme = programmeRepository.findByDescriptionAndDifficulte(programme.getDescription(), programme.getDifficulte());
                user1.setProgramme(programme);
            }
            
            userRepository.save(user1); // on sauvegarde l'utilisateur en base de donne
            
            System.out.println("\n\n>>>>>>l' objectif et le programme de l'utilisateur "+user1.getNom()+"\n a ete defini avec success !");
            return "suggestionCour/formConfirmationSaveObjectif";
        }    
    }

    @GetMapping("/testClassification")
    public String testClassification(){
        return "suggestionCour/test_classification";
    }


}

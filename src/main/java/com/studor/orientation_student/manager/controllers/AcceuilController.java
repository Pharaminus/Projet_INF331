package com.studor.orientation_student.manager.controllers;

// import java.io.File;
// import java.util.UUID;

// import net.sourceforge.tess4j.Tesseract;
// import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.studor.orientation_student.entities.profilejobprediction.Matter;
import com.studor.orientation_student.entities.profilejobprediction.User;
import com.studor.orientation_student.manager.repositories.profilejobpredictrepository.MatterRepository;
import com.studor.orientation_student.manager.repositories.profilejobpredictrepository.UserRepository;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/studor")
// @Secured("ROLE_USER")
public class AcceuilController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private MatterRepository matterRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/acceuil")
    public String acceuil() {
        
        return "Acceuil.html";
        
    }

    @GetMapping("/matiere")
    public String matiere() {
        return "formMatiere";
    }

    @PostMapping("/createMatiere")
    public String createMatiere(@RequestParam("nom") String nom, @RequestParam("coef") Integer coef) {
        // Matter matter = new Matter(matiere.getNom(), matiere.getCoef(), null);
        // System.out.println("===========>" + coef);
        if (nom != "" && coef != null) {
            Matter matter = new Matter(nom, coef, null, null, null);
            matterRepository.save(matter);
        }
        return "formMatiere";
    }

    // importation des notes de l'etudiant

    // @GetMapping("/testImportation")
    // public String extractTextFromImage() {
    // Tesseract tesseract = new Tesseract();
    // try {
    // String text = tesseract.doOCR(new File("produire_information.png"));
    // System.out.println(text);
    // } catch (TesseractException e) {
    // e.printStackTrace();
    // }

    // return "formExtractionText";
    // }

    @GetMapping("/import")
    public String importer() {
        return "formExtractionText";
    }

    // entree permettant d'inserer un utilisateur
    @GetMapping("/profil")
    // @PreAuthorize("hasRole('USER')")
    public String profil() {
        return "formUser";
    }

    // recuperation des informations envoyer par l'utilisateur
    @PostMapping("/saveProfil")
    // @PreAuthorize("hasRole('USER')")
    public String saveProfil(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom,
            @RequestParam("email") String email, @RequestParam("pass") String pass) {

        if (userRepository.findByEmail(email) == null) {
            User user = new User(email, prenom, pass, null);
            userRepository.save(user);
        }

        return "formUser";
    }

    @GetMapping("/login")
    // @PreAuthorize("hasRole('USER')")
    public String login() {
        return "loginForm";
    }

    @PostMapping("/loginUser")
    // @PreAuthorize("hasRole('USER')")
    public String loginUser( @RequestParam("email") String email, @RequestParam("pass") String pass) {
        HttpSession session = request.getSession();
        User user = new User();
        user = userRepository.findByMotDePasseAndEmail(pass, email);
        System.out.println("===========>>> ok test" + email + " " + pass);

        if (user != null){
            
            session.setAttribute("user", user);
            Cookie cookie = new Cookie("sessionId", session.getId());
            cookie.setMaxAge(24 * 60 *60);
            response.addCookie(cookie);

            User user2 = (User) session.getAttribute("user");
            System.out.println("(((((((((==)))))))))"+user2.getEmail()+" cookie : ");
            return "Acceuil";
        }    
        else {
            System.out.println("===========>>> ok test" + email + " " + pass);
            return "loginForm";
        }

    }

}

package com.studor.orientation_student.manager.controller.nouriture;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studor.orientation_student.entities.nutrition.Utilisateurs;
import com.studor.orientation_student.manager.repository.nutrition.UtilisateursRepository;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateursController {
    private final UtilisateursRepository utilisateurRepository;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
    public UtilisateursController(UtilisateursRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @PostMapping
    public ResponseEntity<Utilisateurs> createUtilisateur(@RequestBody Utilisateurs utilisateur) {
        Utilisateurs nouveauUtilisateur = utilisateurRepository.save(utilisateur);
        return ResponseEntity.ok(nouveauUtilisateur);
    }

    @GetMapping("affiche/{id}")
    public ResponseEntity<Utilisateurs> getUtilisateur(@PathVariable Long id) {
        Optional<Utilisateurs> utilisateurOptional = utilisateurRepository.findById(id);
        if (utilisateurOptional.isPresent()) {
            Utilisateurs utilisateur = utilisateurOptional.get();
            return ResponseEntity.ok(utilisateur);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("modifiecation/{id}")
    public ResponseEntity<Utilisateurs> updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateurs utilisateur) {
        Optional<Utilisateurs> utilisateurOptional = utilisateurRepository.findById(id);
        if (utilisateurOptional.isPresent()) {
            Utilisateurs utilisateurExistant = utilisateurOptional.get();
            utilisateurExistant.setNom(utilisateur.getNom());
            utilisateurExistant.setMotDePasse(utilisateur.getMotDePasse());
            utilisateurExistant.setIdentifiant(utilisateur.getIdentifiant());
            Utilisateurs utilisateurMiseAJour = utilisateurRepository.save(utilisateurExistant);
            return ResponseEntity.ok(utilisateurMiseAJour);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        Optional<Utilisateurs> utilisateurOptional = utilisateurRepository.findById(id);
        if (utilisateurOptional.isPresent()) {
            Utilisateurs utilisateur = utilisateurOptional.get();
            utilisateurRepository.delete(utilisateur);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

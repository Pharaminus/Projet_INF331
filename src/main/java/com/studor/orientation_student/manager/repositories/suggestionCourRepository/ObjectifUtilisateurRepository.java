package com.studor.orientation_student.manager.repositories.suggestionCourRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.studor.orientation_student.entities.suggestionCourEntities.ObjectifUtilisateur;
// import java.util.List;

public interface ObjectifUtilisateurRepository extends JpaRepository<ObjectifUtilisateur, Long> {
    ObjectifUtilisateur findByDescriptionAndMoyenneAndStatuVise(String description, Double moyenne, String statuVise);
}

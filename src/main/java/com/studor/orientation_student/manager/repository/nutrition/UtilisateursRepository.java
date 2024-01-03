package com.studor.orientation_student.manager.repository.nutrition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studor.orientation_student.entities.nutrition.Utilisateurs;


@Repository
public interface UtilisateursRepository extends JpaRepository<Utilisateurs, Long>{
    
}

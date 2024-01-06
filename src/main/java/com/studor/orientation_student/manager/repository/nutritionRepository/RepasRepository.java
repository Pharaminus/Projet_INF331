package com.studor.orientation_student.manager.repository.nutritionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studor.orientation_student.entities.nutritionEntities.Repas;

@Repository
public interface RepasRepository extends JpaRepository<Repas, Long>{

    Repas findByNomAndPrix(String nom, double prix);
    
}

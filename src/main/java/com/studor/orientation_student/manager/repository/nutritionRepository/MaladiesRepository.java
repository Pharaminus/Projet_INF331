package com.studor.orientation_student.manager.repository.nutritionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studor.orientation_student.entities.nutritionEntities.Maladies;


@Repository
public interface MaladiesRepository extends JpaRepository<Maladies, Long>{

    Maladies findByNom(String nom);
    
}

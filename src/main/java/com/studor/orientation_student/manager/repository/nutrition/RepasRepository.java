package com.studor.orientation_student.manager.repository.nutrition;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studor.orientation_student.entities.nutrition.Repas;
import java.util.List;



public interface RepasRepository extends JpaRepository<Repas, Long>{

    // recherche d'un repas en fonction du nom 
    List<Repas> findByNom(String nom);

    // recherche d'un repas en fonction du prix et du nom
    List<Repas> findByNomAndPrix(String nom, double prix);    

    // recherche d'un plat en fonction d prix
    List<Repas> findByPrix(double prix);
}

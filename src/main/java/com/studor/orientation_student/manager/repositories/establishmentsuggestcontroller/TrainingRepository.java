package com.studor.orientation_student.manager.repositories.establishmentsuggestcontroller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studor.orientation_student.entities.establishmentsuggestion.Domain;
import com.studor.orientation_student.entities.establishmentsuggestion.Establishment;
import com.studor.orientation_student.entities.establishmentsuggestion.Training;

import java.util.List;

public  interface TrainingRepository extends JpaRepository<Training, Long>{

    List<Training> findByCout(double cout);
    List<Training> findByEstablishment(Establishment establishment);
    List<Training> findByDuree(int duree);
    Training findByNom(String nom);
    List<Training> findByDomain(Domain domain);
}

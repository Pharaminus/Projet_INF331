package com.studor.orientation_student.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studor.orientation_student.entity.establishmentsuggestion.Establishment;
import java.util.List;


@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, Long>{
    List<Establishment> findByLocalisation(String localisation);
    Establishment findByNom(String nom);
}

package com.studor.orientation_student.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studor.orientation_student.entities.suggestionCourEntities.establishmentsuggestion.Domain;
import com.studor.orientation_student.entities.suggestionCourEntities.establishmentsuggestion.Establishment;

import java.util.List;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Long>{
    Domain findByNom(String nom);
    List<Domain> findByEstablishment(Establishment establishment);
}

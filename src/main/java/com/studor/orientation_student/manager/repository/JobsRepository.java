package com.studor.orientation_student.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studor.orientation_student.entities.profilejobprediction.Category;
import com.studor.orientation_student.entities.profilejobprediction.Jobs;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Long>{
    Jobs findByNom(String nom);
    List<Jobs> findByCategory(Category category);
    List<Jobs> findByDureeFormation(int dureeFormation);
    List<Jobs> findBySalaire(Long salaire);
    Optional<Jobs> findById(Long id);
}

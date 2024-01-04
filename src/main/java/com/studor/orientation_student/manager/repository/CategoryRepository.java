package com.studor.orientation_student.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studor.orientation_student.entities.profilejobprediction.Category;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    Category findByNom(String nom);
    Category findByDescription(String description);
    Optional<Category> findById(Long id);
}

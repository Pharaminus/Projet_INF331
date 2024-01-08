package com.studor.orientation_student.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studor.orientation_student.entities.suggestionCourEntities.profilejobprediction.Matter;

public interface MatterRepository extends JpaRepository<Matter, Long>{
    Matter findByNomAndCoefLessThanEqual(String nom, int coef);
}

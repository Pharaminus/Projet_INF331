package com.studor.orientation_student.manager.repository;

import com.studor.orientation_student.entities.Matter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatterRepository extends JpaRepository<Matter, Long>{
    Matter findByNomAndCoefLessThanEqual(String nom, int coef);
}

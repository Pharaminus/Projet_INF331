package com.studor.orientation_student.manager.repository.nutrition;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studor.orientation_student.entities.nutrition.Maladies;

public interface MaladiesRepository extends JpaRepository<Maladies, Long>{

    Optional<Maladies> findByNom(String nomMaladie);

    boolean existsByNom(String nom);

    void deleteByNom(String nom);

   
}

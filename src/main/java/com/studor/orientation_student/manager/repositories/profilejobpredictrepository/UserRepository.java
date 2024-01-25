package com.studor.orientation_student.manager.repositories.profilejobpredictrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studor.orientation_student.entities.profilejobprediction.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
    User findByEmail(String email);
    User findByNom(String nom);
    User findByMotDePasse(String motDePasse);
    User findByMotDePasseAndEmail(String pass, String email);
}

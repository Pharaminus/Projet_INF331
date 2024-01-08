package com.studor.orientation_student.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studor.orientation_student.entities.suggestionCourEntities.profilejobprediction.User;

import java.util.List;


public interface UserRepository  extends JpaRepository<User, Long>{
    User findByEmail(String email);
   User findByMotDePasseAndEmail(String motDePasse, String email);
   
   

}

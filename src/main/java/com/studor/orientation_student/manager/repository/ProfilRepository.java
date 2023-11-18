package com.studor.orientation_student.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studor.orientation_student.entity.Profil;

import weka.core.Instances;


@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long>{
    Instances getInstancesFromDatabase();
}

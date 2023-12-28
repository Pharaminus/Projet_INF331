package com.studor.orientation_student.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studor.orientation_student.entity.establishmentsuggestion.Training;

public  interface TrainingController extends JpaRepository<Training, Long>{}

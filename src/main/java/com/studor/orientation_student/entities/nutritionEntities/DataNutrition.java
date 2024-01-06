package com.studor.orientation_student.entities.nutritionEntities;

<<<<<<< HEAD
public class DataNutrition { 
=======

import java.util.List;

import jakarta.persistence.*;

@Entity
public class DataNutrition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

>>>>>>> be9830f8f4e48ac3ded449c8aee88581c4c714a5
    private String nomrepas1;
    private String nomrepas2;
    private String nomrepas3;
    private String nom;
<<<<<<< HEAD
    private String symptoms;
=======
    private List<String> symptoms;
>>>>>>> be9830f8f4e48ac3ded449c8aee88581c4c714a5

    public DataNutrition() {
    }

<<<<<<< HEAD
    public DataNutrition(String nomrepas1, String nomrepas2, String nomrepas3, String nom, String symptoms) {
=======
    public DataNutrition(String nomrepas1, String nomrepas2, String nomrepas3, String nom, List<String> symptoms) {
>>>>>>> be9830f8f4e48ac3ded449c8aee88581c4c714a5
        this.nomrepas1 = nomrepas1;
        this.nomrepas2 = nomrepas2;
        this.nomrepas3 = nomrepas3;
        this.nom = nom;
        this.symptoms = symptoms;
    }

    public String getNomrepas1() {
        return nomrepas1;
    }

    public void setNomrepas1(String nomrepas1) {
        this.nomrepas1 = nomrepas1;
    }

    public String getNomrepas2() {
        return nomrepas2;
    }

    public void setNomrepas2(String nomrepas2) {
        this.nomrepas2 = nomrepas2;
    }

    public String getNomrepas3() {
        return nomrepas3;
    }

    public void setNomrepas3(String nomrepas3) {
        this.nomrepas3 = nomrepas3;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

<<<<<<< HEAD
    public String getSymptoms() {
=======
    public List<String> getSymptoms() {
>>>>>>> be9830f8f4e48ac3ded449c8aee88581c4c714a5
        return symptoms;
    }

    public void setSymptoms(String string) {
        this.symptoms = string;
    }
    
}
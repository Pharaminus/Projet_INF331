package com.studor.orientation_student.entities.nutritionEntities;

<<<<<<< HEAD
=======
<<<<<<< HEAD
public class DataNutrition { 
=======

import java.util.List;
>>>>>>> 5c5518d1aae51446ecea22dd789d7ddde17fea9e

import jakarta.persistence.*;


<<<<<<< HEAD
public class DataNutrition {
=======
>>>>>>> be9830f8f4e48ac3ded449c8aee88581c4c714a5
>>>>>>> 5c5518d1aae51446ecea22dd789d7ddde17fea9e
    private String nomrepas1;
    private String nomrepas2;
    private String nomrepas3;
    private String nom;
<<<<<<< HEAD
    private String symptoms;
=======
<<<<<<< HEAD
    private String symptoms;
=======
    private List<String> symptoms;
>>>>>>> be9830f8f4e48ac3ded449c8aee88581c4c714a5
>>>>>>> 5c5518d1aae51446ecea22dd789d7ddde17fea9e

    public DataNutrition() {
    }

<<<<<<< HEAD
    public DataNutrition(String nomrepas1, String nomrepas2, String nomrepas3, String nom, String symptoms) {
=======
<<<<<<< HEAD
    public DataNutrition(String nomrepas1, String nomrepas2, String nomrepas3, String nom, String symptoms) {
=======
    public DataNutrition(String nomrepas1, String nomrepas2, String nomrepas3, String nom, List<String> symptoms) {
>>>>>>> be9830f8f4e48ac3ded449c8aee88581c4c714a5
>>>>>>> 5c5518d1aae51446ecea22dd789d7ddde17fea9e
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
<<<<<<< HEAD
    public String getSymptoms() {
=======
    public List<String> getSymptoms() {
>>>>>>> be9830f8f4e48ac3ded449c8aee88581c4c714a5
>>>>>>> 5c5518d1aae51446ecea22dd789d7ddde17fea9e
        return symptoms;
    }

    public void setSymptoms(String string) {
        this.symptoms = string;
    }
    
}
package com.studor.orientation_student.entities.nutritionEntities;

public class DataNutrition { 
    private String nomrepas1;
    private String nomrepas2;
    private String nomrepas3;
    private String nom;
    private String symptoms;

    public DataNutrition() {
    }

    public DataNutrition(String nomrepas1, String nomrepas2, String nomrepas3, String nom, String symptoms) {
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

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String string) {
        this.symptoms = string;
    }
    
}
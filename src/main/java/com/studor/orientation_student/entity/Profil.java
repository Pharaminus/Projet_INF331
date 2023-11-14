package com.studor.orientation_student.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profil")
public class Profil {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private String sexe;
    private String loisirs;
    private String metierDuPere;
    private String metierDeLaMere;
    private String religion;
    private String sport;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getLoisirs() {
        return loisirs;
    }

    public void setLoisirs(String loisirs) {
        this.loisirs = loisirs;
    }

    public String getMetierDuPere() {
        return metierDuPere;
    }

    public void setMetierDuPere(String metierDuPere) {
        this.metierDuPere = metierDuPere;
    }

    public String getMetierDeLaMere() {
        return metierDeLaMere;
    }

    public void setMetierDeLaMere(String metierDeLaMere) {
        this.metierDeLaMere = metierDeLaMere;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

}
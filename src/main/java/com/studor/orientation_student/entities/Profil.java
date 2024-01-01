package com.studor.orientation_student.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profil {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String sexe;
    private String loisirs;
    private String metierDuPere;
    private String metierDeLaMere;
    private String religion;
    private String sport;
    

    public Profil(String nom, String prenom, Date dateDeNaissance, String sexe, String loisirs, String metierDuPere,
            String metierDeLaMere, String religion, String sport) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        this.loisirs = loisirs;
        this.metierDuPere = metierDuPere;
        this.metierDeLaMere = metierDeLaMere;
        this.religion = religion;
        this.sport = sport;
    }

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

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
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

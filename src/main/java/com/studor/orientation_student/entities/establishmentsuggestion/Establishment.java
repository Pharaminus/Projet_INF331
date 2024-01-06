package com.studor.orientation_student.entities.establishmentsuggestion;

import java.sql.Blob;
import java.util.List;

import com.studor.orientation_student.entities.profilejobprediction.Profil;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Establishment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String localisation;
    private String nomDirecteur;

    @Lob
    private Blob image;

    @ManyToMany(mappedBy = "establishments")
    private List<Training> trainings;
    
    @ManyToMany(mappedBy = "establishments")
    private List<Domain> domains;

    @ManyToOne
    private Profil profil;

    public Establishment(String nom, String localisation, String nomDirecteur, Blob image,
            List<Domain> domains, Profil profil) {
        this.nom = nom;
        this.localisation = localisation;
        this.nomDirecteur = nomDirecteur;
        this.image = image;
        this.domains = domains;
        this.profil = profil;
    }

    public Establishment() {
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public List<Domain> getDomains() {
        return domains;
    }

    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public String getNomDirecteur() {
        return nomDirecteur;
    }

    public void setNomDirecteur(String nomDirecteur) {
        this.nomDirecteur = nomDirecteur;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }
}

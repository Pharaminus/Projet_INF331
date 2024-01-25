package com.studor.orientation_student.entities.profilejobprediction;

import java.sql.Blob;
import java.util.List;

import com.studor.orientation_student.entities.establishmentsuggestion.Training;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Job {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private Long salaire;

    @Lob
    private Blob image;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    private List<Profil> profils;

    @ManyToOne
    private Subdomain option;

    @OneToOne
    private Training training;

    public Job(String nom, String description, Long salaire, Blob image, List<Profil> profils,
            Subdomain option, Training training) {
        this.nom = nom;
        this.description = description;
        this.salaire = salaire;
        this.image = image;
        this.profils = profils;
        this.option = option;
        this.training = training;
    }

    public Job() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSalaire() {
        return salaire;
    }

    public void setSalaire(Long salaire) {
        this.salaire = salaire;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public List<Profil> getProfils() {
        return profils;
    }

    public void setProfils(List<Profil> profils) {
        this.profils = profils;
    }

    public Subdomain getOption() {
        return option;
    }

    public void setOption(Subdomain option) {
        this.option = option;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}

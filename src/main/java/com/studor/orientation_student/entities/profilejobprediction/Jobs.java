package com.studor.orientation_student.entities.profilejobprediction;

import java.sql.Blob;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Jobs {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private int dureeFormation;
    private Long salaire;

    @Lob
    private Blob image;

    @OneToMany(mappedBy = "jobs", cascade = CascadeType.ALL)
    private List<Profil> profils;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Jobs(String nom, String description, int dureeFormation, Long salaire, Blob image, List<Profil> profils,
            Category category) {
        this.nom = nom;
        this.description = description;
        this.dureeFormation = dureeFormation;
        this.salaire = salaire;
        this.image = image;
        this.profils = profils;
        this.category = category;
    }

    public Jobs() {
    }

    public int getDureeFormation() {
        return dureeFormation;
    }
    public void setDureeFormation(int dureeFormation) {
        this.dureeFormation = dureeFormation;
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

    public Long getId() {
        return id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public Category getCategory() {
        return category;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public List<Profil> getProfil() {
        return profils;
    }

    public void setProfil(List<Profil> profils) {
        this.profils = profils;
    }
}

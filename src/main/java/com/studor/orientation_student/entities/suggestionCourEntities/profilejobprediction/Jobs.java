package com.studor.orientation_student.entities.suggestionCourEntities.profilejobprediction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Jobs {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private int dureeFormation;
    private Long salaire;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Jobs(String nom, String description, int dureeFormation, Long salaire, Category category) {
        this.nom = nom;
        this.description = description;
        this.dureeFormation = dureeFormation;
        this.salaire = salaire;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public Category getCategory() {
        return category;
    }
}

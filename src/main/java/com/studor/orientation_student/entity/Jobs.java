package com.studor.orientation_student.entity;

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
    private int duree_formation;
    private Long salaire;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Jobs(String nom, String description, int duree_formation, Long salaire, Category category) {
        this.nom = nom;
        this.description = description;
        this.duree_formation = duree_formation;
        this.salaire = salaire;
        this.category = category;
    }

    public int getDuree_formation() {
        return duree_formation;
    }
    public void setDuree_formation(int duree_formation) {
        this.duree_formation = duree_formation;
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

    public String getCategory() {
        return category.getNom();
    }
    public void setCategory(String nom) {
        this.category.setNom(nom);
    }

    public Long getSalaire() {
        return salaire;
    }
    public void setSalaire(Long salaire) {
        this.salaire = salaire;
    }
}

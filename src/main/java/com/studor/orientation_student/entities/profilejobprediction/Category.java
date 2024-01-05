package com.studor.orientation_student.entities.profilejobprediction;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Jobs> metier;

    public Category(String nom, String description, List<Jobs> metier) {
        this.nom = nom;
        this.description = description;
        this.metier = metier;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Jobs> getMetier() {
        return metier;
    }
    public void setMetier(List<Jobs> metier) {
        this.metier = metier;
    }
}

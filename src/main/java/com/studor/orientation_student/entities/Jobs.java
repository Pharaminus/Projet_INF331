package com.studor.orientation_student.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Jobs {
    
    @Id
    private String nom;
    private String description;

    @ManyToOne
    @JoinColumn(name = "categorie")
    private Category category;

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
}

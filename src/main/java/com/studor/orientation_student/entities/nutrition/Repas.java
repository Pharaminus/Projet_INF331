package com.studor.orientation_student.entities.nutrition;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Repas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String constituant;
    private String description;
    private double apportEnergetique;
    private double prix;

    @OneToMany(mappedBy = "repas", cascade = CascadeType.ALL)
    private List<Restaurants> restaurant = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "utilisateurs_id")
    private Utilisateurs utilisateurs;    

    @OneToMany(mappedBy = "repas", cascade = CascadeType.ALL)
    private List<Maladies> maladies = new ArrayList<>();

    public Repas() {
    }
    public Repas(String nom, String constituant, String description, double apportEnergetique, double prix) {
        this.nom = nom;
        this.constituant = constituant;
        this.description = description;
        this.apportEnergetique = apportEnergetique;
        this.prix = prix;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getConstituant() {
        return constituant;
    }
    public void setConstituant(String constituant) {
        this.constituant = constituant;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getApportEnergetique() {
        return apportEnergetique;
    }
    public void setApportEnergetique(double apportEnergetique) {
        this.apportEnergetique = apportEnergetique;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public List<Maladies> getMaladies() {
        return maladies;
    }
    public void setMaladies(List<Maladies> maladies) {
        this.maladies = maladies;
    }
   
    
}

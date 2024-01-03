package com.studor.orientation_student.entities.nutrition;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Utilisateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String motDePasse;
    private String identifiant;
    
    @OneToMany(mappedBy = "utilisateurs", cascade = CascadeType.ALL)
    private List<Repas> repas = new ArrayList<>();

    public Utilisateurs() {
    }

    public Utilisateurs(String nom, String motDePasse, String identifiant) {
        this.nom = nom;
        this.motDePasse = motDePasse;
        this.identifiant = identifiant;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    
    
}

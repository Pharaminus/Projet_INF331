package com.studor.orientation_student.entities.suggestionCourEntities.establishmentsuggestion;

import java.util.List;

import com.studor.orientation_student.entities.suggestionCourEntities.profilejobprediction.Profil;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Establishment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String localisation;
    
    @OneToMany(mappedBy = "establishment", cascade = CascadeType.ALL)
    private List<Domain> domains;

    @ManyToOne
    private Profil profil;

    public Establishment(String nom, String localisation, List<Domain> domains, Profil profil) {
        this.nom = nom;
        this.localisation = localisation;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }
}

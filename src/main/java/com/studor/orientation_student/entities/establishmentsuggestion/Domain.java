package com.studor.orientation_student.entities.establishmentsuggestion;

import java.util.List;

import com.studor.orientation_student.entities.profilejobprediction.Option;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;

    @ManyToMany
    private List<Establishment> establishments;

    @OneToMany(mappedBy = "domain")
    private List<Option> options;

    public Domain(String nom, String description, List<Establishment> establishments, List<Option> options) {
        this.nom = nom;
        this.description = description;
        this.establishments = establishments;
        this.options = options;
    }

    public Domain() {
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

    public List<Establishment> getEstablishments() {
        return establishments;
    }

    public void setEstablishments(List<Establishment> establishments) {
        this.establishments = establishments;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}

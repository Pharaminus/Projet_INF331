package com.studor.orientation_student.entity.establishmentsuggestion;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "domain", cascade =  CascadeType.ALL)
    private List<Training> trainings;

    @ManyToOne
    private Establishment establishment;

    public Domain(String nom, List<Training> trainings, Establishment establishment) {
        this.nom = nom;
        this.trainings = trainings;
        this.establishment = establishment;
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

    public List<Training> getTraining() {
        return trainings;
    }

    public void setTraining(List<Training> trainings) {
        this.trainings = trainings;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public void setEstablishment(Establishment establishment) {
        this.establishment = establishment;
    }
}
